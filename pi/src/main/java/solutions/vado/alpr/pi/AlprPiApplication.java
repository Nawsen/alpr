package solutions.vado.alpr.pi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//TODO remove this when impl security
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AlprPiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlprPiApplication.class, args);
    }
}
