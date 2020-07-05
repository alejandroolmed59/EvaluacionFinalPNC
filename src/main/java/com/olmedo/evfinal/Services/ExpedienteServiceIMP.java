package com.olmedo.evfinal.Services;

import com.olmedo.evfinal.Repositories.ExpedienteRepository;
import com.olmedo.evfinal.domain.Expediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpedienteServiceIMP implements ExpedienteService{
    @Autowired
    ExpedienteRepository expedienteRepository;

    @Override
    public List<Expediente> getByQuery(Integer tipo, String valor) throws DataAccessException {
        List<Expediente> resultado=null;
        switch (tipo){
            case 1:
                resultado= expedienteRepository.findByNombre(valor);
                break;
            case 2:
                resultado= expedienteRepository.findByApellido(valor);
                break;
        }
        return resultado;
    }
}
