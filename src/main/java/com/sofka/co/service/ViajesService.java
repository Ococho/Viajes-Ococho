package com.sofka.co.service;

import com.sofka.co.repository.BusesRepository;
import com.sofka.co.repository.PersonasRepository;
import com.sofka.co.repository.ViajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViajesService implements IViajesService {

    @Autowired
    private ViajesRepository viajesRepository;

    @Autowired
    private BusesRepository busesRepository;

    @Autowired
    private PersonasRepository personasRepository;
    //...
}
