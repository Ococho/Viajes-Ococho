package com.sofka.co.repository;

import com.sofka.co.model.Adulto;
import com.sofka.co.model.BusGrande;
import com.sofka.co.model.Menor;
import com.sofka.co.model.Viaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ViajesRepository {
    private List<Viaje> viajes = new ArrayList<>();

    @Autowired
    private BusesRepository busesRepository;

    public ViajesRepository() {
        this.viajes.add(new Viaje(
                        new BusGrande("AAA113",
                        new ArrayList<>(
                                List.of(new Adulto("Juan", "Cruz", "1234567890", 25, "1234567890"),
                                        new Menor("Maria", "Ruiz", "1234567891", 10,
                                        new Adulto("Juan", "Cruz", "1234567890", 25, "1234567890")))),
                                33),
                        "Marinilla",
                        "Ene-2-11:59-A.M"));
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