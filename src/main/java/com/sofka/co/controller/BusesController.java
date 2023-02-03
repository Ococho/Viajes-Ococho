package com.sofka.co.controller;

import com.sofka.co.model.frame.Bus;
import com.sofka.co.model.frame.Persona;
import com.sofka.co.service.IBusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("buses")
public class BusesController {

    @Autowired
    private IBusesService busesService;

    @PostMapping()
    public ResponseEntity registrarBus(@RequestBody Bus bus) {
        busesService.registrarBus(bus);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("{placa}")
    public ResponseEntity subirPasajero(@RequestBody Persona persona, @PathVariable("placa") String placa) {
        busesService.agregarPasajeroABusPorPlaca(placa, persona);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity obtenerBuses() {
        return new ResponseEntity(busesService.obtenerBuses(), HttpStatus.FOUND);
    }

    @GetMapping("{placa}")
    public ResponseEntity obtenerBus(@PathVariable("placa") String placa) {
        return new ResponseEntity(busesService.obtenerBusPorPlaca(placa), HttpStatus.FOUND);
    }
}