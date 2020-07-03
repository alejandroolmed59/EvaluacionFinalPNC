package com.olmedo.evfinal.Services;

import com.olmedo.evfinal.Repositories.MunicipioRepository;
import com.olmedo.evfinal.domain.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class MunicipioServiceIMP implements MunicipioService{
    @Autowired
    MunicipioRepository municipioRepository;

    @PersistenceContext(unitName = "modelo-persistence")
    EntityManager entityManager;
    @Override
    public List<Municipio> findAll() throws DataAccessException {
        return municipioRepository.findAllMunicipios();
    }
}
