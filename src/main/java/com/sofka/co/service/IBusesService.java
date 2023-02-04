package com.sofka.co.service;

import com.sofka.co.model.BusGrande;
import com.sofka.co.model.BusPequenno;
import com.sofka.co.model.frame.Bus;
import com.sofka.co.model.frame.Persona;

import java.util.List;

public interface IBusesService {
    List<Bus> obtenerBuses();

    Bus obtenerBusPorPlaca(String placa);

    void registrarBusGrande(BusGrande busGrande);

    void registrarBusPequenno(BusPequenno busPequenno);

    void agregarPasajeroABusPorPlaca(String placa, Persona persona);
}