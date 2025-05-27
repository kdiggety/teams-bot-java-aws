package klewisjr.teams.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TeamsBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamsBotApplication.class, args);
    }
}
