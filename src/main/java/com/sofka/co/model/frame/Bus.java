package com.sofka.co.model.frame;

import lombok.Data;

import java.util.List;

@Data
public abstract class Bus {
    private String placa;
    private List<Persona> pasajeros;
    private int capacidad;

    public void agregarPasajero(Persona pasajero) {
        if (this.capacidad > 0) {
            this.disminuirCapacidad();
            this.pasajeros.add(pasajero);
        } else {
            System.out.println("Bus lleno");
        }
    }

    public void disminuirCapacidad() {
        this.capacidad --;
    }
}