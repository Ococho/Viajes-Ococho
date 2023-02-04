package com.sofka.co.model;

import com.sofka.co.model.frame.Persona;

public class Adulto extends Persona {
    private String telefono;

    public Adulto(String nombre, String apellido, String id, int edad, String telefono) {
        super(nombre, apellido, id, edad);
        this.setTelefono(telefono);
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }
}