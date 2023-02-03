package com.sofka.co.controller;

import com.sofka.co.service.IPersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
public class PersonasController {

    @Autowired
    private IPersonasService personasService;

//    @GetMapping()
//    public ResponseEntity obtenerPersonas() {
//        return new ResponseEntity(personasService., HttpStatus.FOUND);
//    }
}