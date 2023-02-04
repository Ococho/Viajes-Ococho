package com.sofka.co.model.frame;

import lombok.Data;

import java.util.List;

@Data
public abstract class Bus {
    private String placa;
    private List<Persona> pasajeros;
    private int capacidad;

    public Bus(String placa, List<Persona> pasajeros, int capacidad) {
        this.setPlaca(placa);
        this.setPasajeros(pasajeros);
        this.setCapacidad(capacidad);
    }

    public void agregarPasajero(Persona persona) {
        if (this.capacidad > 0) {
            this.disminuirCapacidad();
            this.pasajeros.add(persona);
        } else {
            System.out.println("Bus lleno");
        }
    }

    public void disminuirCapacidad() {
        this.capacidad--;
    }
}