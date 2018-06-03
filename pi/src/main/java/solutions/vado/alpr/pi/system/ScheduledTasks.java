package solutions.vado.alpr.pi.system;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import solutions.vado.alpr.pi.domain.Module;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Value("${alpr.url}")
    public String url;

    @Value("${alpr.locationId}")
    public String locationId;

    @Scheduled(fixedRate = 120000)
    public void aliveBeepRequestSender() throws UnknownHostException {
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new StringHttpMessageConverter());
        String uri = "http://" + url + "/api/modules/beep";
        Module module = new Module();
        Gson gson = new Gson();
        module.setId(Long.valueOf(locationId));
        module.setName("NEW MODULE");
        module.setIp(Inet4Address.getLocalHost().toString());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");

        HttpEntity<String> httpEntity = new HttpEntity<String>(gson.toJson(module), httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(uri, httpEntity, String.class);

    }


    private void log(String taskName) {
        logger.info("Finished task: " + taskName + " :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }
}
