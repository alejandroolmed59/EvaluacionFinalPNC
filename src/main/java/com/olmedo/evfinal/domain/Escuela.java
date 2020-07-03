package com.olmedo.evfinal.domain;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "escuela")
public class Escuela {
    @Id
    @Column(name = "idEscuela")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEscuela;

    @Column(name = "idMunicipio")
    private int idMunicipio;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private boolean estado;

    public int getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(int idEscuela) {
        this.idEscuela = idEscuela;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
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


    public Escuela(int idEscuela, int idMunicipio, String nombre, String descripcion, boolean estado) {
        this.idEscuela = idEscuela;
        this.idMunicipio = idMunicipio;
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

