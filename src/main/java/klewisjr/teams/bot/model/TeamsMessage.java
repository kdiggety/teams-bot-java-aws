package klewisjr.teams.bot.model;

//import lombok.Builder;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;

//@Data
//@Builder
//@RequiredArgsConstructor
public class TeamsMessage {
    private String text;
    private String conversationId;

    public String getText() {
        return text;
    }

    public String getConversationId() {
        return conversationId;
    }
}
