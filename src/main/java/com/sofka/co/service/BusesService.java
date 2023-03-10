package com.sofka.co.service;

import com.sofka.co.model.Adulto;
import com.sofka.co.model.BusGrande;
import com.sofka.co.model.BusPequenno;
import com.sofka.co.model.frame.Bus;
import com.sofka.co.model.frame.Persona;
import com.sofka.co.repository.BusesRepository;
import com.sofka.co.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusesService implements IBusesService {

    @Autowired
    private BusesRepository busesRepository;

    @Autowired
    private PersonasRepository personasRepository;

    @Override
    public List<Bus> obtenerBuses() {
        return busesRepository.obtenerBuses();
    }

    @Override
    public Bus obtenerBusPorPlaca(String placa) {
        return busesRepository.obtenerBusPorPlaca(placa);
    }

    @Override
    public void registrarBusGrande(BusGrande busGrande) {
        busesRepository.registrarBusGrande(busGrande);
    }

    @Override
    public void registrarBusPequenno(BusPequenno busPequenno) {
        busesRepository.registrarBusPequenno(busPequenno);
    }

    @Override
    public void agregarPasajeroABusPorPlaca(String placa, Persona persona) {
        busesRepository.agregarPasajeroABusPorPlaca(placa, personasRepository.obtenerPersonaPorId(persona.getId()));
    }
}