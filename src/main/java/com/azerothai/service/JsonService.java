package com.azerothai.service;

import com.azerothai.model.Personaje;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonService {

    private ObjectMapper mapper = new ObjectMapper();

    public String convertirAJson(Personaje personaje) throws Exception {

        return mapper.writeValueAsString(personaje);
    }

    public Personaje convertirDesdeJson(String json) throws Exception {

        return mapper.readValue(json, Personaje.class);
    }
}