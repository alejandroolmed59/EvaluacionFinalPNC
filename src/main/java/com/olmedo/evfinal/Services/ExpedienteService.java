package com.olmedo.evfinal.Services;

import com.olmedo.evfinal.domain.Expediente;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ExpedienteService {
    public List<Expediente> getByQuery(Integer tipo, String valor) throws DataAccessException;
}
