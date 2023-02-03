package com.sofka.co.repository;

import com.sofka.co.model.frame.Bus;
import com.sofka.co.model.frame.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class BusesRepository {
    private List<Bus> buses;

    public BusesRepository() {
        this.buses = new ArrayList<>();
    }

    public List<Bus> obtenerBuses() {
        return this.buses;
    }

    public Bus obtenerBusPorPlaca(String placa) {
        return this.buses.stream().filter(bus -> bus.getPlaca().equals(placa)).findFirst().orElse(null);
    }

    public void registrarBus(Bus bus) {
        this.buses.add(bus);
    }

    public void agregarPasajeroABusPorPlaca(String placa, Persona pasajero) {
        Objects.requireNonNull(this.buses.stream().filter(bus -> bus.getPlaca().equals(placa))
                                                                .findFirst()
                                                                .orElse(null))
                                                                .agregarPasajero(pasajero);
    }
}