package com.algaworks.algacomments.moderation.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ModerationInput {

    private String commentId;
    private String text;
}
