package com.sofka.co.service;

import com.sofka.co.model.Adulto;
import com.sofka.co.model.Menor;
import com.sofka.co.model.frame.Persona;
import com.sofka.co.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonasService implements IPersonasService {

    @Autowired
    private PersonasRepository personasRepository;

    @Override
    public List<Persona> obtenerPersonas() {
        return personasRepository.obtenerPersonas();
    }

    @Override
    public void modificarPersona(Adulto personaAModificar) {
        personasRepository.setPersonas(
                personasRepository.obtenerPersonas()
                        .stream()
                        .map(persona -> persona.getId().equals(personaAModificar.getId()) ? personaAModificar : persona)
                        .collect(Collectors.toList()));
    }

    @Override
    public void registrarAdulto(Adulto adulto) {
        personasRepository.registrarAdulto(adulto);
    }

    @Override
    public void registrarMenor(Menor menor) {
        personasRepository.registrarMenor(menor);
    }
}