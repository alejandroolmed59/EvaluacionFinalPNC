package com.olmedo.evfinal.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(schema = "public", name = "expediente")
public class Expediente {
    @Id
    @Column(name = "idexpediente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExpediente;

    @NotEmpty(message = "El campo nombre no puede estar vacio")
    @Column(name = "nombre")
    private String nombre;

    @NotEmpty(message = "El campo apellido no puede estar vacio")
    @Column(name = "apellido")
    private String apellido;

    @NotEmpty(message = "El campo carnet de minoridad no puede estar vacio")
    @Column(name = "carneminoridad")
    private String carnetMinoridad;

    @NotNull(message = "El campo fecha no puede estar vacio")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechanacimiento")
    private Date fechaNac;

    @NotEmpty(message = "El campo direccion no puede estar vacio")
    @Column(name = "direccion")
    private String direccion;

    @NotEmpty(message = "El campo telefono fijo no puede estar vacio")
    @Column(name = "telfijo")
    private String telfijo;

    @NotEmpty(message = "El campo telefono movil no puede estar vacio")
    @Column(name = "telmovil")
    private String telmovil;

    @NotEmpty(message = "El campo nombre del padre fijo no puede estar vacio")
    @Column(name = "nombrepadre")
    private String nombrepadre;

    @NotEmpty(message = "El campo nombre de la madre no puede estar vacio")
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

    public String getEdad1Delegate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.fechaNac );
        if (this.fechaNac == null) return "";
        else {
            LocalDate localFechaNac = LocalDateTime.ofInstant(cal.toInstant(), cal.getTimeZone().toZoneId()).toLocalDate();
            int edad = Period.between(localFechaNac, LocalDate.now()).getYears();
            return new Integer(edad).toString();
        }
    }
}
