package klewisjr.teams.bot.client;

import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeClient;
import software.amazon.awssdk.services.bedrockruntime.model.*;
import org.springframework.stereotype.Service;

@Service
public class BedrockClient {
    private final BedrockRuntimeClient client = BedrockRuntimeClient.create();

    public String summarizeLog(String logText) {
        String payload = String.format("{\"prompt\": \"Summarize the following logs:\\n\\n%s\\n\\nSummary:\", \"max_tokens_to_sample\": 300, \"temperature\": 0.5, \"top_k\": 250, \"top_p\": 1.0 }", logText);

        InvokeModelRequest request = InvokeModelRequest.builder()
            .modelId("anthropic.claude-v2")
            .contentType("application/json")
            .accept("application/json")
            .body(SdkBytes.fromUtf8String(payload))
            .build();

        return client.invokeModel(request).body().asUtf8String();
    }
}
