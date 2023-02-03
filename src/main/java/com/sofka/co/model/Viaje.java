package com.sofka.co.model;

import com.sofka.co.model.frame.Bus;
import lombok.Data;

@Data
public class Viaje {
    private Bus bus;
    private String destino;
    private String horario;


}