package com.olmedo.evfinal.Services;

import com.olmedo.evfinal.domain.Municipio;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface MunicipioService {
    public List<Municipio> findAll() throws DataAccessException;
}
