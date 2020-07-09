package com.olmedo.evfinal.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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


    @NotEmpty(message = "El campo nombre no puede estar vacio")
    @Column(name = "nombre")
    private String nombre;

    @NotEmpty(message = "El campo descripcion no puede estar vacio")
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

