package com.olmedo.evfinal.domain;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "materia")
public class Materia {
    @Id
    @Column(name = "idmateria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmateria;

    @Column(name = "materia")
    private String materia;

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