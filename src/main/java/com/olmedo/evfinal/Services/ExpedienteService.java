package com.olmedo.evfinal.Services;

import com.olmedo.evfinal.ViewModels.NotasAlumno;
import com.olmedo.evfinal.domain.Expediente;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ExpedienteService {
    public List<Expediente> getByQuery(Integer tipo, String valor) throws DataAccessException;
    public List<Expediente> findAll() throws DataAccessException;
    public NotasAlumno getResultados(int idExpediente) throws DataAccessException;
}
