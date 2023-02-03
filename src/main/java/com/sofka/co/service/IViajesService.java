package com.sofka.co.service;

import com.sofka.co.model.Viaje;

import java.util.List;

public interface IViajesService {
    List<Viaje> obtenerViajes();

    Viaje obtenerViajePorHorario(String horario);

    void registrarViaje(Viaje viaje);

    void modificarHorario(Viaje viaje, String horarioNuevo);

    void modificarBus(Viaje viaje, String placa);

    void modificarDestino(Viaje viaje, String destinoNuevo);
}