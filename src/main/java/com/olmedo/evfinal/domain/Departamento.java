package com.olmedo.evfinal.domain;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "departamento")
public class Departamento {
    @Id
    @Column(name = "iddepartamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartamento;

    @Column(name = "nombredepartamento")
    private String nombreDepartamento;

    public Departamento() {
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
}
