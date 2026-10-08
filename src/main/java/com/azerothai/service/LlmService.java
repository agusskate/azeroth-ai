package com.azerothai.service;

import java.net.URI;
import java.net.http.HttpClient;        
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LlmService {
    private static final String OLLAMA_URL = "http://localhost:11434/api/generate";
    private static final String MODEL = "llama3.2";
    private HttpClient cliente = HttpClient.newHttpClient();
    private ObjectMapper mapper = new ObjectMapper();

    public String generarRespuesta(String prompt) throws Exception {

        String url = OLLAMA_URL;

        String json = mapper.writeValueAsString(
                java.util.Map.of(
                        "model", MODEL,
                        "prompt", prompt,
                        "stream", false));

        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> respuesta = cliente.send(
                peticion,
                HttpResponse.BodyHandlers.ofString());

        if (respuesta.statusCode() != 200) {
                throw new RuntimeException(
                "Error al comunicarse con Ollama. Código HTTP: " +  respuesta.statusCode());
        }

        System.out.println("RESPUESTA RAW DE OLLAMA:");
        System.out.println(respuesta.body());

        String respuestaLlm = mapper.readTree(respuesta.body())
                .get("response")
                .asText();

        respuestaLlm = respuestaLlm
                .replace("```json", "")
                .replace("```", "")
                .trim();

        return respuestaLlm;
    }
}