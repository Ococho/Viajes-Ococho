package com.sofka.co.repository;

import com.sofka.co.model.Viaje;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ViajesRepository {
    private List<Viaje> viajes;

    public ViajesRepository() {
        this.viajes = new ArrayList<>();
    }

    public List<Viaje> obtenerViajes() {
        return this.viajes;
    }

    public Viaje obtenerViajePorHorario(String horario) {
        return this.viajes.stream().filter(viaje -> viaje.getHorario().equals(horario)).findFirst().orElse(null);
    }

    public void registrarViaje(Viaje viaje) {
        this.viajes.add(viaje);
    }
}