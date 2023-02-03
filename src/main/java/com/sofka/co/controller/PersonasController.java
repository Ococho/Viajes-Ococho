package com.sofka.co.controller;

import com.sofka.co.model.frame.Persona;
import com.sofka.co.service.IPersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class PersonasController {

    @Autowired
    private IPersonasService personasService;

    @PostMapping()
    public ResponseEntity registrarPersona(@RequestBody Persona persona) {
        personasService.registrarPersona(persona);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity obtenerPersonas() {
        return new ResponseEntity(personasService.obtenerPersonas(), HttpStatus.FOUND);
    }

    @PutMapping()
    public ResponseEntity modificarPersona(@RequestBody Persona personaAModificar) {
        return new ResponseEntity(personasService.modificarPersona(personaAModificar), HttpStatus.ACCEPTED);
    }


}