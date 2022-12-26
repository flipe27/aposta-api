package com.codex.aposta;

import com.codex.aposta.controller.ApostadorController;
import com.codex.aposta.model.dto.ApostadorIn;
import com.codex.aposta.service.ApostadorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.CREATED;

@ExtendWith(MockitoExtension.class)
public class ApostadorControllerTest {
    @InjectMocks
    private ApostadorController apostadorController;
    @Mock
    private ApostadorService apostadorService;
    private ApostadorIn apostadorIn;

    @BeforeEach
    void setup() {
        apostadorIn = new ApostadorIn();
    }

    @Test
    void deveSalvarApostador() {
        var response = assertDoesNotThrow(() -> apostadorController.salvarApostador(apostadorIn));
        assertEquals(ResponseEntity.status(CREATED).build(), response);
    }
}
