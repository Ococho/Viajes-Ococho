package com.sofka.co.controller;

import com.sofka.co.model.Adulto;
import com.sofka.co.model.BusGrande;
import com.sofka.co.model.BusPequenno;
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

    @PostMapping("grande")
    public ResponseEntity registrarBusGrande(@RequestBody BusGrande busGrande) {
        busesService.registrarBusGrande(busGrande);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("pequenno")
    public ResponseEntity registrarBusPequenno(@RequestBody BusPequenno busPequenno) {
        busesService.registrarBusPequenno(busPequenno);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("{placa}") // TODO: Acceder con el ID de la persona y recorrer el arreglo
    public ResponseEntity subirPasajero(@RequestBody Adulto persona, @PathVariable("placa") String placa) {
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