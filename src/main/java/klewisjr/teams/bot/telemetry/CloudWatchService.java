package klewisjr.teams.bot.telemetry;

import software.amazon.awssdk.services.cloudwatch.CloudWatchClient;
import software.amazon.awssdk.services.cloudwatch.model.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class CloudWatchService {
    private final CloudWatchClient cw = CloudWatchClient.create();

    public String getLatencyStats(String serviceName) {
        Instant end = Instant.now();
        Instant start = end.minusSeconds(300);

        GetMetricStatisticsRequest request = GetMetricStatisticsRequest.builder()
            .namespace("YourServiceNamespace")
            .metricName("Latency")
            .dimensions(Dimension.builder().name("ServiceName").value(serviceName).build())
            .startTime(start)
            .endTime(end)
            .period(60)
            .statistics(Statistic.AVERAGE)
            .build();

        List<Datapoint> datapoints = cw.getMetricStatistics(request).datapoints();
        return datapoints.isEmpty() ? "No data." : "Latency p90: " + datapoints.get(0).average() + " ms";
    }
}
