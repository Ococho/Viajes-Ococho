package com.sofka.co.repository;

import com.sofka.co.model.Viaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ViajesRepository {
    private List<Viaje> viajes;

    @Autowired
    private BusesRepository busesRepository;

    public ViajesRepository() {
        this.viajes = Arrays.asList(new Viaje(busesRepository.obtenerBusPorPlaca("AAA111"), "Jardín", "Ene 1 12:59 P.M."),
                                    new Viaje(busesRepository.obtenerBusPorPlaca("AAA112"), "Caldas", "Ene 1 11:59 A.M."));
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