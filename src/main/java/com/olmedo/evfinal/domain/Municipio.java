package com.olmedo.evfinal.domain;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "municipio")
public class Municipio {
    @Id
    @Column(name = "idmunicipio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMunicipio;
    @Column(name = "nombremunicipio")
    private String nombreMunicipio;
    @Column(name = "iddepartamento")
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
