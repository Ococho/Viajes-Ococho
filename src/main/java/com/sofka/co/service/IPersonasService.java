package com.sofka.co.service;

import com.sofka.co.model.Adulto;
import com.sofka.co.model.Menor;
import com.sofka.co.model.frame.Persona;

import java.util.List;

public interface IPersonasService {
    List<Persona> obtenerPersonas();

    void modificarPersona(Adulto personaNueva);

    void registrarAdulto(Adulto adulto);

    void registrarMenor(Menor menor);
}