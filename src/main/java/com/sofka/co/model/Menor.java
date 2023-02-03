package com.sofka.co.model;

import com.sofka.co.model.frame.Persona;

public class Menor extends Persona {
    public Persona adultoResponsable;

    public Menor(String nombre, String apellido, Persona adultoResponsable, String id) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEdad(10);
        this.setId(id);
        this.setAdultoResponsable(adultoResponsable);
    }

    public void setAdultoResponsable(Persona adultoResponsable) {
        this.adultoResponsable = adultoResponsable;
    }

    public Persona getAdultoResponsable() {
        return adultoResponsable;
    }
}