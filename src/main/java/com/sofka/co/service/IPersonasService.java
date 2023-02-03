package com.sofka.co.service;

import com.sofka.co.model.frame.Persona;

import java.util.List;

public interface IPersonasService {
    List<Persona> obtenerPersonas();
    Persona modificarPersona(Persona personaNueva);
    void registrarPersona(Persona persona);
}
