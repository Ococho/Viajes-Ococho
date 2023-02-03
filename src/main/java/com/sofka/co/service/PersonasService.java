package com.sofka.co.service;

import com.sofka.co.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonasService implements IPersonasService {

    @Autowired
    private PersonasRepository personasRepository;
    //...
}
