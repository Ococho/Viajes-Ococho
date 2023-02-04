package com.sofka.co.model;

import com.sofka.co.model.frame.Bus;
import lombok.Data;

@Data
public class Viaje {
    private Bus bus;
    private String destino;
    private String horario;

    public Viaje(BusGrande bus, String destino, String horario) {
        this.bus = bus;
        this.destino = destino;
        this.horario = horario;
    }
}