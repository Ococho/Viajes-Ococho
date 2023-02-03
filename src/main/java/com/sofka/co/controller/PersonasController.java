package com.sofka.co.controller;

import com.sofka.co.service.IPersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
public class PersonasController {

    @Autowired
    private IPersonasService personasService;
    //...
}