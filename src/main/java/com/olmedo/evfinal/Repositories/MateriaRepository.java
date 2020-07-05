package com.olmedo.evfinal.Repositories;

import com.olmedo.evfinal.domain.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MateriaRepository extends JpaRepository<Materia, Integer> {
    @Query(value = "SELECT * FROM public.materia ORDER BY idmateria ASC ", nativeQuery = true)
    public List<Materia> findAllOrdenado();
}
