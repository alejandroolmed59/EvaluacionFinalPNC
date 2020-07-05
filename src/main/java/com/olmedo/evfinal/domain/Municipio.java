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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "iddepartamento")
    private Departamento departamento;

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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
