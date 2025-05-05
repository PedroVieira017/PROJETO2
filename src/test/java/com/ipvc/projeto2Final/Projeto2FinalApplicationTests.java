package com.ipvc.projeto2Final;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Projeto2FinalApplicationTests {

    @Test
    void contextLoads() {
        System.setProperty("spring.test.context", "true");
        System.out.println("✔️ Teste OK: contexto carregado com sucesso.");
    }
}
