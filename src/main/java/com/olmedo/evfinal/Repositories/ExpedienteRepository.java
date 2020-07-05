package com.olmedo.evfinal.Repositories;

import com.olmedo.evfinal.ViewModels.ExpedienteXmateria;
import com.olmedo.evfinal.domain.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpedienteRepository extends JpaRepository<Expediente, Integer> {
    public List<Expediente> findByNombre(String nombre);
    public List<Expediente> findByApellido(String apellido);

    @Query(value = "SELECT ex.idexpediente, m.idmateria, m.materia, me.annio, me.ciclo, me.nota\n" +
            "FROM public.expediente ex INNER JOIN public.materiaexpediente me ON ex.idexpediente=me.idexpediente INNER JOIN public.materia m ON me.idmateria=m.idmateria\n" +
            "WHERE ex.idexpediente=:idexpediente" , nativeQuery=true)
    public List<ExpedienteXmateria> obtenerMateriasDeExpediente(@Param("idexpediente") Integer idExpediente);
}
