package com.olmedo.evfinal.ViewModels;

public class NotasAlumno {
    private int idExpediente;
    private String nombre;
    private String apellido;
    private Integer aprobadas;
    private  Integer reprobadas;
    private Number promedio;

    public NotasAlumno(Integer aprobadas, Integer reprobadas, Number promedio) {
        this.aprobadas = aprobadas;
        this.reprobadas = reprobadas;
        this.promedio = promedio;
    }

    public NotasAlumno() {
    }

    public Integer getAprobadas() {
        return aprobadas;
    }

    public void setAprobadas(Integer aprobadas) {
        this.aprobadas = aprobadas;
    }

    public Integer getReprobadas() {
        return reprobadas;
    }

    public void setReprobadas(Integer reprobadas) {
        this.reprobadas = reprobadas;
    }

    public Number getPromedio() {
        return promedio;
    }

    public void setPromedio(Number promedio) {
        this.promedio = promedio;
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
}
