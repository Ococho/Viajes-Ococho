package com.sofka.co.service;

import com.sofka.co.model.Adulto;
import com.sofka.co.model.Menor;
import com.sofka.co.model.frame.Persona;
import com.sofka.co.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonasService implements IPersonasService {

    @Autowired
    private PersonasRepository personasRepository;

    @Override
    public List<Persona> obtenerPersonas() {
        return personasRepository.obtenerPersonas();
    }

    @Override
    public Persona modificarPersona(Persona personaAModificar) {
        var lugarEnLista = this.obtenerPersonas()
                .indexOf(personasRepository
                        .obtenerPersonaPorId(
                                personaAModificar.getId()));
        this.obtenerPersonas().set(lugarEnLista, personaAModificar);
        return personasRepository.obtenerPersonaPorId(personaAModificar.getId());
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