package com.algaworks.algacomments.moderation.api.controller;

import com.algaworks.algacomments.moderation.api.model.ModerationInput;
import com.algaworks.algacomments.moderation.api.model.ModerationOutput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ModerationController {

    @PostMapping("/moderate")
    public ModerationOutput moderateComment(@RequestBody ModerationInput input) {

        // Lógica simples de moderação: bloqueia comentários que contenham palavras ofensivas
        String[] palavrasOfensivas = {"ódio", "xingamento"};

        for (String palavra : palavrasOfensivas) {
            if (input.getText().toLowerCase().contains(palavra)) {
                return ModerationOutput.builder()
                        .approved(false)
                        .reason("Comentário bloqueado por conter linguagem ofensiva.")
                        .build();
            }
        }
        return ModerationOutput.builder()
                .approved(true)
                .reason("Comentário aprovado.")
                .build();
    }
}
