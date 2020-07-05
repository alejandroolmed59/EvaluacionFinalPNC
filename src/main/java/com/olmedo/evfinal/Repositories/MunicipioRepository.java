package com.olmedo.evfinal.Repositories;

import com.olmedo.evfinal.domain.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {
    @Query(value = "SELECT * from public.Municipio ORDER BY idMunicipio ASC", nativeQuery = true)
    public List<Municipio> findAllMunicipios();
}
