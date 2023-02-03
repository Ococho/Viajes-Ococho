package com.sofka.co.model;

import com.sofka.co.model.frame.Persona;

public class Adulto extends Persona {
    private String telefono;

    public Adulto(String nombre, String apellido, String id) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEdad(18);
        this.setId(id);
        this.setTelefono("1234567890");
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }
}