package com.cieep.modelos;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "equipo")
public class Equipo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String marca;
    @Column
    private String modelo;

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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    //Aquí estamos haciendo la relación con Alumno, también hay que crear los getters y setters
    @OneToOne(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Alumno alumno;

    public Equipo() {
    }

    @Override
    public String toString() {
        return "Equipo{ " +
                "id = " + id +
                ", marca = '" + marca + '\'' +
                ", modelo = '" + modelo + '\'' +
                '}';
    }
}
