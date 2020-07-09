package com.olmedo.evfinal.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(schema = "public", name = "materia")
public class Materia {
    @Id
    @Column(name = "idmateria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmateria;

    @NotEmpty(message = "El campo materia no puede estar vacio")
    @Column(name = "materia")
    private String materia;

    @NotEmpty(message = "El campo descripcion no puede estar vacio")
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private boolean estado;

    public Materia(int idMateria, String materia, String descripcion, boolean estado) {
        this.idmateria = idMateria;
        this.materia = materia;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Materia() {
    }

    public int getIdMateria() {
        return idmateria;
    }

    public void setIdMateria(int idMateria) {
        this.idmateria = idMateria;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}