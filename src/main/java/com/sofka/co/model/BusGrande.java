package com.sofka.co.model;

import com.sofka.co.model.frame.Bus;

import java.util.ArrayList;

public class BusGrande extends Bus {

    public BusGrande (Viaje viaje, String placa) {
        this.setPlaca(placa);
        this.setPasajeros(new ArrayList<>());
        this.setViaje(viaje);
        this.setCapacidad(33);
    }
}