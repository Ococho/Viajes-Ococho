package com.sofka.co.model;

import com.sofka.co.model.frame.Bus;

import java.util.ArrayList;

public class BusPequenno extends Bus {

    public BusPequenno (Viaje viaje, String placa) {
        this.setPlaca(placa);
        this.setPasajeros(new ArrayList<>());
        this.setViaje(viaje);
        this.setCapacidad(13);
    }
}