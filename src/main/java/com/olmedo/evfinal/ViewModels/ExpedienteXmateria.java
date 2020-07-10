package com.olmedo.evfinal.ViewModels;

import javax.persistence.*;

public interface ExpedienteXmateria {
    int getId();
    int getIdexpediente();
    int getIdmateria();
    String getMateria();
    String getAnnio();
    String getCiclo();
    Number getNota();
}
