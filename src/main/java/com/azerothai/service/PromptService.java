package com.azerothai.service;

public class PromptService {

    public String construirPrompt(
            String raza,
            String clase,
            String personalidad) {

        String prompt = """
                Genera un personaje de fantasía inspirado en World of Warcraft.

                Raza: %s
                Clase: %s
                Personalidad: %s

                El personaje debe tener:
                - Un nombre
                - Nivel 80
                - Una especialización adecuada para su clase
                - Una personalidad coherente
                - Una historia breve

                Devuelve únicamente un JSON válido con esta estructura:

                {
                    "nombre": "...",
                    "raza": "...",
                    "clase": "...",
                    "nivel": 80,
                    "especializacion": "...",
                    "personalidad": "...",
                    "historia": "..."
                }
                """.formatted(raza, clase, personalidad);

        return prompt;
    }
}

