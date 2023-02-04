package com.sofka.co.repository;

import com.sofka.co.model.BusGrande;
import com.sofka.co.model.BusPequenno;
import com.sofka.co.model.frame.Bus;
import com.sofka.co.model.frame.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class BusesRepository {
    private List<Bus> buses = new ArrayList<>();

    public BusesRepository() {
        this.buses.add(new BusGrande("AAA111"));
        this.buses.add(new BusPequenno("AAA112"));
    }

    public List<Bus> obtenerBuses() {
        return this.buses;
    }

    public Bus obtenerBusPorPlaca(String placa) {
        return this.buses.stream().filter(bus -> bus.getPlaca().equals(placa)).findFirst().orElse(null);
    }

    public void registrarBusGrande(BusGrande busGrande) {
        this.buses.add(busGrande);
    }

    public void registrarBusPequenno(BusPequenno busPequenno) {
        this.buses.add(busPequenno);
    }

    public void agregarPasajeroABusPorPlaca(String placa, Persona pasajero) {
        Objects.requireNonNull(
                        this.buses.stream().filter(bus -> bus.getPlaca().equals(placa))
                                .findFirst()
                                .orElse(null))
                                .agregarPasajero(pasajero);
    }
}