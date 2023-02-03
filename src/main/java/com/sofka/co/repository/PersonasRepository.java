package com.sofka.co.repository;

import com.sofka.co.model.Adulto;
import com.sofka.co.model.Menor;
import com.sofka.co.model.frame.Persona;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class PersonasRepository {
    private List<Persona> personas;

    public PersonasRepository() {
        this.personas = Arrays.asList(new Adulto("Juan", "Cruz", "1234567890"),
                                        new Adulto("Maria", "Ruiz", "1234567891"));
        this.registrarPersona(new Menor("Luis", "Cruz", this.obtenerPersonaPorId("1234567890"), "1234567892"));
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