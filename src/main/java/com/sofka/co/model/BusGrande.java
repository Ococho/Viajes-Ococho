package com.sofka.co.model;

import com.sofka.co.model.frame.Bus;

public class BusGrande extends Bus {

    public BusGrande(String placa) {
        super(placa);
        this.setCapacidad(33);
    }
}