package com.azerothai;

import java.util.Scanner;

import com.azerothai.model.Personaje;
import com.azerothai.service.JsonService;
import com.azerothai.service.LlmService;
import com.azerothai.service.PromptService;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== AZEROTH AI ===");

        // 1. Pedimos los datos al usuario

        System.out.print("Introduce la raza: ");
        String raza = scanner.nextLine();

        System.out.print("Introduce la clase: ");
        String clase = scanner.nextLine();

        System.out.print("Introduce la personalidad: ");
        String personalidad = scanner.nextLine();


        // 2. Construimos el prompt

        PromptService promptService = new PromptService();

        String prompt = promptService.construirPrompt(
                raza,
                clase,
                personalidad
        );


        // 3. Mostramos el prompt

        System.out.println();
        System.out.println("=== PROMPT GENERADO ===");
        System.out.println(prompt);


        // 4. Enviamos el prompt al LLM

        LlmService llmService = new LlmService();

        String respuestaIA =
                llmService.generarRespuesta(prompt);


        // 5. Mostramos la respuesta de la IA

        System.out.println();
        System.out.println("=== RESPUESTA DE LA IA ===");
        System.out.println(respuestaIA);


        // 6. Convertimos el JSON en Personaje

        JsonService jsonService = new JsonService();

        Personaje personaje =
                jsonService.convertirDesdeJson(respuestaIA);


        // 7. Mostramos el personaje final

        System.out.println();
        System.out.println("=== PERSONAJE FINAL ===");

        System.out.println("Nombre: " + personaje.getNombre());
        System.out.println("Raza: " + personaje.getRaza());
        System.out.println("Clase: " + personaje.getClase());
        System.out.println("Nivel: " + personaje.getNivel());
        System.out.println("Especialización: " + personaje.getEspecializacion());
        System.out.println("Personalidad: " + personaje.getPersonalidad());
        System.out.println("Historia: " + personaje.getHistoria());

        scanner.close();
    }
}

