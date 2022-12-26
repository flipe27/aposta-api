package com.codex.aposta.controller;

import com.codex.aposta.model.dto.ApostaIn;
import com.codex.aposta.model.dto.ApostaOut;
import com.codex.aposta.model.dto.ApostasOut;
import com.codex.aposta.service.ApostaService;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ApostaController {
    private final ApostaService apostaService;

    @PostMapping("/aposta")
    public ResponseEntity<ApostaOut> salvarAposta(@Valid @RequestBody ApostaIn apostaIn) {
        ApostaOut apostaOut = apostaService.salvarAposta(apostaIn);
        return ResponseEntity.status(CREATED).body(apostaOut);
    }

    @GetMapping("/buscaApostasIdApostador/{idApostador}")
    public List<ApostasOut> buscaApostasIdApostador(@PathVariable Long idApostador) {
        return apostaService.buscaApostasIdApostador(idApostador);
    }
}
