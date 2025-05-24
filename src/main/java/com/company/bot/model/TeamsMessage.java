package com.company.bot.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class TeamsMessage {
    private final String text;
    private final String conversationId;
}
