package klewisjr.teams.bot;

import klewisjr.teams.bot.model.TeamsMessage;
import klewisjr.teams.bot.telemetry.CloudWatchService;
import klewisjr.teams.bot.telemetry.LogsService;
import klewisjr.teams.bot.client.BedrockClient;
import org.springframework.stereotype.Service;

@Service
public class BotService {
    private final CloudWatchService cloudWatchService;
    private final LogsService logsService;
    private final BedrockClient bedrockClient;

    public BotService(CloudWatchService cloudWatchService, LogsService logsService, BedrockClient bedrockClient) {
        this.cloudWatchService = cloudWatchService;
        this.logsService = logsService;
        this.bedrockClient = bedrockClient;
    }

    // Routes messages to CloudWatch, OpenSearch, or Bedrock.
    public String handleMessage(TeamsMessage message) {
        String userInput = message.getText();

        if (userInput.contains("latency")) {
            return cloudWatchService.getLatencyStats("ServiceABC");
        } else if (userInput.contains("errors")) {
            String logs = logsService.getRecentErrors("/aws/lambda/serviceABC");
            return bedrockClient.summarizeLog(logs);
        } else {
            return "Sorry, I couldn’t understand your request. Try asking about latency or errors.";
        }
    }
}
