package com.sofka.co.controller;

import com.sofka.co.model.Adulto;
import com.sofka.co.model.Menor;
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

    @PostMapping("adulto")
    public ResponseEntity registrarPersona(@RequestBody Adulto adulto) {
        personasService.registrarAdulto(adulto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("menor")
    public ResponseEntity registrarPersona(@RequestBody Menor menor) {
        personasService.registrarMenor(menor);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity obtenerPersonas() {
        return new ResponseEntity(personasService.obtenerPersonas(), HttpStatus.FOUND);
    }

    @PutMapping() // TODO: Acceder con un ID y recorrer el arreglo
    public ResponseEntity modificarPersona(@RequestBody Adulto personaAModificar) {
        personasService.modificarPersona(personaAModificar);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}