package com.sofka.co.model.frame;

import lombok.Data;

@Data
public abstract class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String id;
}