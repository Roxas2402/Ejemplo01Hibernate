package com.cieep.modelos;

import jakarta.persistence.*;

import java.io.Serializable;

//LOS @ EXTRAÑOS SON PARA LA SEGUNDA FORMA DEL CRUD


@Entity
@Table(name = "alumnos")

public class Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column
    private String apellidos;
    @Column
    private String dni;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    //La relación 1 - 1 se marca como relación OneToOne || Aquí estamos haciendo la relación con equipo
    @OneToOne(fetch = FetchType.LAZY)
    //Aquí hay que crear getters y setters
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    public Alumno() {
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }

    public Alumno(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
