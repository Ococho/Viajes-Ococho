package com.sofka.co.service;

import com.sofka.co.repository.BusesRepository;
import com.sofka.co.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusesService implements IBusesService {

    @Autowired
    private BusesRepository busesRepository;

    @Autowired
    private PersonasRepository personasRepository;
    //...
}
