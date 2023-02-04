package com.sofka.co.controller;

import com.sofka.co.model.Viaje;
import com.sofka.co.service.IViajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("viajes")
public class ViajesController {

    @Autowired
    private IViajesService viajesService;

    @PostMapping()
    public ResponseEntity registrarViaje(@RequestBody Viaje viaje) {
        viajesService.registrarViaje(viaje);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity obtenerViajes() {
        return new ResponseEntity(viajesService.obtenerViajes(), HttpStatus.FOUND);
    }

    @GetMapping("{horario}")
    public ResponseEntity obtenerViaje(@PathVariable("horario") String horario) {
        return new ResponseEntity(viajesService.obtenerViajePorHorario(horario), HttpStatus.FOUND);
    }

    @PutMapping("{horario}")
    public ResponseEntity modificarHorario(@RequestBody Viaje viaje, @PathVariable("horario") String horario) {
        viajesService.modificarHorario(viaje, horario);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PutMapping("{placa}")
    public ResponseEntity modificarBus(@RequestBody Viaje viajeAModificar, @PathVariable("placa") String placa) {
        viajesService.modificarBus(viajeAModificar, placa);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PutMapping("{destino}")
    public ResponseEntity modificarDestino(@RequestBody Viaje viajeAModificar, @PathVariable("destino") String destino) {
        viajesService.modificarDestino(viajeAModificar, destino);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}