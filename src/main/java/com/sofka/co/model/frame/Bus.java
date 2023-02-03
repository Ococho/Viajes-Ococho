package com.sofka.co.model.frame;

import com.sofka.co.model.Viaje;
import lombok.Data;

import java.util.List;

@Data
public abstract class Bus {
    private String placa;
    private List<Persona> pasajeros;
    private Viaje viaje;
    private int capacidad;

    public void agregarPasajero(Persona pasajero) {
      this.pasajeros.add(pasajero);
    }
    public void asignarViaje(Viaje viaje) {
        this.viaje = viaje;
    }
}