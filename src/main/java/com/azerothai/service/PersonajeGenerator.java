package com.azerothai.service;

import com.azerothai.model.Personaje;

public class PersonajeGenerator {

    public Personaje generar(String raza, String clase) {

        Personaje personaje = new Personaje();

        personaje.setRaza(raza);
        personaje.setClase(clase);
        personaje.setNivel(80);

        if (raza.equalsIgnoreCase("Orco") && clase.equalsIgnoreCase("Guerrero")) {

            personaje.setNombre("Grommash");
            personaje.setEspecializacion("Armas");
            personaje.setPersonalidad("Feroz y honorable");
            personaje.setHistoria(
                "Un guerrero orco que busca demostrar su valor en batalla."
            );

        } else if (raza.equalsIgnoreCase("Humano") && clase.equalsIgnoreCase("Mago")) {

            personaje.setNombre("Aldric");
            personaje.setEspecializacion("Arcano");
            personaje.setPersonalidad("Inteligente y curioso");
            personaje.setHistoria(
                "Un mago humano obsesionado con descubrir los secretos de la magia."
            );

        } else {

            personaje.setNombre("Aventurero");
            personaje.setEspecializacion("Sin determinar");
            personaje.setPersonalidad("Misterioso");
            personaje.setHistoria(
                "Un aventurero que acaba de comenzar su viaje por Azeroth."
            );
        }

        return personaje;
    }
}