package com.sofka.co.model;

import com.sofka.co.model.frame.Bus;

import java.util.ArrayList;

public class BusPequenno extends Bus {

    public BusPequenno(String placa) {
        this.setPlaca(placa);
        this.setPasajeros(new ArrayList<>());
        this.setCapacidad(13);
    }
}