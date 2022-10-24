package com.cieep.modelos;

import java.io.Serializable;

public class Equipo implements Serializable {
    private int id;
    private String marca, modelo;

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Equipo() {
    }
}
