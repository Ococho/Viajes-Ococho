package com.sofka.co.model;

import com.sofka.co.model.frame.Bus;
import com.sofka.co.model.frame.Persona;

import java.util.List;

public class BusPequenno extends Bus {

    public BusPequenno(String placa, List<Persona> pasajeros, int capacidad) {
        super(placa, pasajeros, capacidad);
        this.setCapacidad(17);
    }
}