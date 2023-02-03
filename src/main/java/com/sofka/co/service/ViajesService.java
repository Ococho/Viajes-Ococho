package com.sofka.co.service;

import com.sofka.co.model.Viaje;
import com.sofka.co.repository.BusesRepository;
import com.sofka.co.repository.ViajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ViajesService implements IViajesService {

    @Autowired
    private ViajesRepository viajesRepository;

    @Autowired
    private BusesRepository busesRepository;

    @Override
    public List<Viaje> obtenerViajes() {
        return viajesRepository.obtenerViajes();
    }

    @Override
    public Viaje obtenerViajePorHorario(String horario) {
        return viajesRepository.obtenerViajePorHorario(horario);
    }

    @Override
    public void registrarViaje(Viaje viaje) {
        viajesRepository.registrarViaje(viaje);
    }

    @Override
    public void modificarHorario(Viaje viaje, String horarioNuevo) {
        this.obtenerViajePorHorario(viaje.getHorario()).setHorario(horarioNuevo);
    }

    @Override
    public void modificarBus(Viaje viajeAModificar, String placa) {
        Objects.requireNonNull(this.obtenerViajes().stream()
                        .filter(viaje -> viaje.equals(viajeAModificar))
                        .findFirst().orElse(null))
                        .setBus(busesRepository.obtenerBusPorPlaca(placa));
    }

    @Override
    public void modificarDestino(Viaje viajeAModificar, String destinoNuevo) {
        Objects.requireNonNull(this.obtenerViajes().stream()
                        .filter(viaje -> viaje.equals(viajeAModificar))
                        .findFirst()
                        .orElse(null))
                        .setDestino(destinoNuevo);
    }
}