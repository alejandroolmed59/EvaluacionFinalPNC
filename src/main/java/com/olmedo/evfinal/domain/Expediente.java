package com.olmedo.evfinal.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "public", name = "expediente")
public class Expediente {
    @Id
    @Column(name = "idexpediente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExpediente;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "carneminoridad")
    private String carnetMinoridad;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechanacimiento")
    private Date fechaNac;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telfijo")
    private String telfijo;
    @Column(name = "telmovil")
    private String telmovil;
    @Column(name = "nombrepadre")
    private String nombrepadre;
    @Column(name = "nombremadre")
    private String nombremadre;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idescuela")
    private Escuela escuela;

    public Expediente() {
    }

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarnetMinoridad() {
        return carnetMinoridad;
    }

    public void setCarnetMinoridad(String carnetMinoridad) {
        this.carnetMinoridad = carnetMinoridad;
    }


    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelfijo() {
        return telfijo;
    }

    public void setTelfijo(String telfijo) {
        this.telfijo = telfijo;
    }

    public String getTelmovil() {
        return telmovil;
    }

    public void setTelmovil(String telmovil) {
        this.telmovil = telmovil;
    }

    public String getNombrepadre() {
        return nombrepadre;
    }

    public void setNombrepadre(String nombrepadre) {
        this.nombrepadre = nombrepadre;
    }

    public String getNombremadre() {
        return nombremadre;
    }

    public void setNombremadre(String nombremadre) {
        this.nombremadre = nombremadre;
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }
}
