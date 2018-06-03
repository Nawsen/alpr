package solutions.vado.alpr.pi.rest;

import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import solutions.vado.alpr.pi.ApplicationProperties;
import solutions.vado.alpr.pi.domain.AlprResponse;
import solutions.vado.alpr.pi.domain.LicensePlate;

@RestController
@RequestMapping("/api")
public class PiPlateController {

    @PostMapping("/")
    public void getPlate(@RequestBody AlprResponse plate) {
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new StringHttpMessageConverter());
        String uri = "http://" + ApplicationProperties.url + "/api/licenseplates";
        LicensePlate convertedPlate = new LicensePlate();
        Gson gson = new Gson();
        convertedPlate.setPlate(plate.results.plate);
        convertedPlate.setLocationId(ApplicationProperties.locationId);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");

        HttpEntity<String> httpEntity = new HttpEntity<String>(gson.toJson(convertedPlate), httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(uri, httpEntity, String.class);
    }

}
