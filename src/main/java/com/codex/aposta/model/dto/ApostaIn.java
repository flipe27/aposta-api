package com.codex.aposta.model.dto;

import lombok.Getter;
import javax.validation.constraints.NotNull;

@Getter
public class ApostaIn {
    @NotNull
    private Long idApostador;
}
