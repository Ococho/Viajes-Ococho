package com.sofka.co.model;

import com.sofka.co.model.frame.Bus;

public class BusPequenno extends Bus {

    public BusPequenno(String placa) {
        super(placa);
        this.setCapacidad(17);
    }
}