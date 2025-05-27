package klewisjr.teams.bot.client;

import klewisjr.teams.bot.config.FeignConfig;
import klewisjr.teams.bot.model.TeamsMessage;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;

/*@FeignClient(
        name = "teamsClient",
        url = "https://graph.microsoft.com",
        configuration = FeignConfig.class
)*/
public interface TeamsClient {
    public String temporary(String logText);
    /*@PostMapping(value = "/v1.0/me/sendMail", consumes = "application/json")
    void sendMessage(
            @RequestHeader("Authorization") String bearerToken,
            @RequestBody TeamsMessage message
    );*/
}

