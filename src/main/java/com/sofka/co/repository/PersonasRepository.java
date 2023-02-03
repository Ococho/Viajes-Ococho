package com.sofka.co.repository;

import com.sofka.co.model.frame.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonasRepository {
    private List<Persona> personas;

    public PersonasRepository() {
        this.personas = new ArrayList<>();
    }

    public List<Persona> obtenerPersonas() {
        return this.personas;
    }

    public Persona obtenerPersonaPorId(String id) {
        return this.personas.stream().filter(persona -> persona.getId().equals(id)).findFirst().orElse(null);
    }

    public void registrarPersona(Persona persona) {
        this.personas.add(persona);
    }
}