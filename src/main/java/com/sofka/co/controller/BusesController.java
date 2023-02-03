package com.sofka.co.controller;

import com.sofka.co.service.IBusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("buses")
public class BusesController {

    @Autowired
    private IBusesService busesService;
    //...
}