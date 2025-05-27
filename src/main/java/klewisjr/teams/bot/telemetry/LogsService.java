package klewisjr.teams.bot.telemetry;

import software.amazon.awssdk.services.cloudwatchlogs.CloudWatchLogsClient;
import software.amazon.awssdk.services.cloudwatchlogs.model.*;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class LogsService {
    private final CloudWatchLogsClient logsClient = CloudWatchLogsClient.create();

    public String getRecentErrors(String logGroup) {
        StartQueryResponse startQuery = logsClient.startQuery(StartQueryRequest.builder()
            .logGroupName(logGroup)
            .startTime(Instant.now().minusSeconds(300).getEpochSecond())
            .endTime(Instant.now().getEpochSecond())
            .queryString("fields @timestamp, @message | filter @message like /ERROR/ | sort @timestamp desc | limit 5")
            .build());

        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }

        GetQueryResultsResponse results = logsClient.getQueryResults(GetQueryResultsRequest.builder()
            .queryId(startQuery.queryId())
            .build());

        StringBuilder sb = new StringBuilder();
        results.results().forEach(row -> row.forEach(field -> sb.append(field.value()).append("\n")));
        return sb.toString();
    }
}
