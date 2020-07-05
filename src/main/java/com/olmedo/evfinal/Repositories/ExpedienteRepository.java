package com.olmedo.evfinal.Repositories;

import com.olmedo.evfinal.domain.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpedienteRepository extends JpaRepository<Expediente, Integer> {
    public List<Expediente> findByNombre(String nombre);
    public List<Expediente> findByApellido(String apellido);
}
