package com.olmedo.evfinal.Repositories;

import com.olmedo.evfinal.domain.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EscuelaRepository extends JpaRepository<Escuela, Integer> {
    public List<Escuela> findAllByMunicipio_IdMunicipio(int idMunicipio);
}
