package com.olmedo.evfinal.domain;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "municipio")
public class Municipio {
    @Id
    @Column(name = "idMunicipio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMunicipio;
    @Column(name = "nombreMunicipio")
    private String nombreMunicipio;
    @Column(name = "idDepartamento")
    private int idDepartamento;

    public Municipio(int idMunicipio, String nombreMunicipio, int idDepartamento) {
        this.idMunicipio = idMunicipio;
        this.nombreMunicipio = nombreMunicipio;
        this.idDepartamento = idDepartamento;
    }

    public Municipio() {
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}
