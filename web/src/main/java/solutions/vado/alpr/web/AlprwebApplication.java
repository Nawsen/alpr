package solutions.vado.alpr.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
//TODO remove this when impl security
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AlprwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlprwebApplication.class, args);
    }
}
