package com.codex.aposta;

import com.codex.aposta.controller.ApostaController;
import com.codex.aposta.model.dto.ApostaIn;
import com.codex.aposta.model.dto.ApostaOut;
import com.codex.aposta.service.ApostaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;

@ExtendWith(MockitoExtension.class)
public class ApostaControllerTest {
    @InjectMocks
    private ApostaController apostaController;
    @Mock
    private ApostaService apostaService;
    private ApostaIn apostaIn;
    private ApostaOut apostaOut;

    @BeforeEach
    void setup() {
        apostaIn = new ApostaIn();
        apostaOut = new ApostaOut("1", "Paulo Fellipe", "flipe27paulo@gmail.com");
    }

    @Test
    void deveSalvarAposta() {
        when(apostaService.salvarAposta(apostaIn)).thenReturn(apostaOut);
        var response = assertDoesNotThrow(() -> apostaController.salvarAposta(apostaIn));
        assertNotNull(response);
        assertEquals(ResponseEntity.status(CREATED).body(apostaOut), response);
    }
}
