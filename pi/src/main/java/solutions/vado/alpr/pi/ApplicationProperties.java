package solutions.vado.alpr.pi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProperties {


    @Value("${alpr.url}")
    public static String url;

    @Value("${alpr.locationId}")
    public static String locationId;

}
