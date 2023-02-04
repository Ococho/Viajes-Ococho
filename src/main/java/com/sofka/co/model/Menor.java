package com.sofka.co.model;

import com.sofka.co.model.frame.Persona;

public class Menor extends Persona {
    public Persona adultoResponsable;

    public Menor(String nombre, String apellido, String id, int edad, Persona adultoResponsable) {
        super(nombre, apellido, id, edad);
        this.setAdultoResponsable(adultoResponsable);
    }

    public void setAdultoResponsable(Persona adultoResponsable) {
        this.adultoResponsable = adultoResponsable;
    }

    public Persona getAdultoResponsable() {
        return adultoResponsable;
    }
}