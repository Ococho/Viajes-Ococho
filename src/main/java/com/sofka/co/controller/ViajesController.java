package com.sofka.co.controller;

import com.sofka.co.service.IViajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("viajes")
public class ViajesController {

    @Autowired
    private IViajesService viajesService;
    //...
}
