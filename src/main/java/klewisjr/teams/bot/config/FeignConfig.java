package klewisjr.teams.bot.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; // BASIC, HEADERS, FULL
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            // For dynamic headers if needed
            // template.header("Authorization", "Bearer " + yourToken);
        };
    }
}