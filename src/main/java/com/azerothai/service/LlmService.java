package com.azerothai.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LlmService {

    private HttpClient cliente = HttpClient.newHttpClient();
    private ObjectMapper mapper = new ObjectMapper();

    public String generarRespuesta(String prompt) throws Exception {

        String url = "http://localhost:11434/api/generate";

        String json = mapper.writeValueAsString(
                java.util.Map.of(
                        "model", "llama3.2",
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