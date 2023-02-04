package com.sofka.co.model.frame;

import lombok.Data;

@Data
public abstract class Persona {
    private String nombre;
    private String apellido;
    private String id;
    private int edad;

    public Persona(String nombre, String apellido, String id, int edad) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setId(id);
        this.setEdad(edad);
    }
}