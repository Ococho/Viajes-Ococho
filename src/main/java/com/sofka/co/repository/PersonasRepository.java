package com.sofka.co.repository;

import com.sofka.co.model.Adulto;
import com.sofka.co.model.Menor;
import com.sofka.co.model.frame.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonasRepository {
    private List<Persona> personas = new ArrayList<>();

    public PersonasRepository() {
        this.personas.add(new Adulto("Juan",
                                    "Cruz",
                                    "1234567890",
                                    25,
                                    "1234567890"));
        this.personas.add(new Menor("Maria",
                                    "Ruiz",
                                    "1234567891",
                                    10,
                                    new Adulto("Juan", "Cruz", "1234567890", 25, "1234567890")));
    }

    public List<Persona> obtenerPersonas() {
        return this.personas;
    }

    public Persona obtenerPersonaPorId(String id) {
        return this.personas.stream().filter(persona -> persona.getId().equals(id)).findFirst().orElse(null);
    }

    public void registrarAdulto(Adulto adulto) {
        this.personas.add(adulto);
    }

    public void registrarMenor(Menor menor) {
        this.personas.add(menor);
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}