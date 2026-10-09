package com.azerothai.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PromptServiceTest {

@Test
void debeIncluirRazaClaseYPersonalidadEnElPrompt() {
    PromptService promptService = new PromptService();

    String prompt = promptService.construirPrompt(
            "Orco",
            "Guerrero",
            "Feroz y honorable"
    );

    assertTrue(prompt.contains("Orco"));
    assertTrue(prompt.contains("Guerrero"));
    assertTrue(prompt.contains("Feroz y honorable"));
}


}
