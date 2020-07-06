package com.olmedo.evfinal.ViewModels;

public class ExpedienteMateriaClase {
    private int idexpediente;
    private int idmateria;
    private String ciclo;
    private String annio;
    private Number nota;

    public ExpedienteMateriaClase() {
    }

    public ExpedienteMateriaClase(int idexpediente) {
        this.idexpediente = idexpediente;
    }

    public int getIdexpediente() {
        return idexpediente;
    }

    public void setIdexpediente(int idexpediente) {
        this.idexpediente = idexpediente;
    }

    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getAnnio() {
        return annio;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

    public Number getNota() {
        return nota;
    }

    public void setNota(Number nota) {
        this.nota = nota;
    }
}
