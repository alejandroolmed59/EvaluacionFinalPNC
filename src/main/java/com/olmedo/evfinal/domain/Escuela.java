package com.olmedo.evfinal.domain;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "escuela")
public class Escuela {
    @Id
    @Column(name = "idescuela")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEscuela;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idmunicipio")
    private Municipio municipio;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private boolean estado;

    @Column(name = "edad")
    private int edad;

    public int getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(int idEscuela) {
        this.idEscuela = idEscuela;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Escuela(int idEscuela, Municipio municipio, String nombre, String descripcion, boolean estado) {
        this.idEscuela = idEscuela;
        this.municipio = municipio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Escuela() {
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

