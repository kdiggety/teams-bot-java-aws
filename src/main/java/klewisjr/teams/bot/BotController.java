package klewisjr.teams.bot;

import klewisjr.teams.bot.client.TeamsClient;
import klewisjr.teams.bot.model.TeamsMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class BotController {
    private final BotService botService;
    private final TeamsClient teamsClient;

    public BotController(BotService botService, TeamsClient teamsClient) {
        this.botService = botService;
        this.teamsClient = teamsClient;
    }

    //Receives incoming messages, sends it to the bot for the response
    @PostMapping
    public ResponseEntity<Void> receiveBotMessage(@RequestBody TeamsMessage message) {
        String reply = botService.handleMessage(message);
        TeamsMessage replyMessage = TeamsMessage.builder().conversationId(message.getConversationId()).text(reply).build();
        teamsClient.sendMessage(message.getConversationId(), replyMessage);
        return ResponseEntity.ok().build();
    }
}
