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

    @Query(value = "SELECT me.id, ex.idexpediente, m.idmateria, m.materia, me.annio, me.ciclo, me.nota\n" +
            "FROM public.expediente ex INNER JOIN public.materiaexpediente me ON ex.idexpediente=me.idexpediente INNER JOIN public.materia m ON me.idmateria=m.idmateria\n" +
            "WHERE ex.idexpediente=:idexpediente" , nativeQuery=true)
    public List<ExpedienteXmateria> obtenerMateriasDeExpediente(@Param("idexpediente") Integer idExpediente);

    @Query(value="INSERT INTO public.materiaexpediente(idexpediente, idmateria, ciclo, annio, nota)VALUES (?1, ?2, ?3, ?4, ?5);", nativeQuery=true)
    public void guardarMateria(int idexpediente, int idmateria, String ciclo, String annio, Number nota);

    @Query(value="UPDATE public.materiaexpediente\n" +
            "\tSET  idmateria=?1, ciclo=?2, annio=?3, nota=?4\n" +
            "\tWHERE id=?5", nativeQuery=true)
    public void editMateria(int idmateria, String ciclo, String annio, Number nota, int id);

    @Query(value="SELECT COUNT(me.nota) AS Reprobadas\n" +
            "FROM public.expediente ex INNER JOIN public.materiaexpediente me ON ex.idexpediente=me.idexpediente\n" +
            "INNER JOIN public.materia m ON me.idmateria=m.idmateria\n" +
            "WHERE ex.idexpediente=? AND me.nota>6.0", nativeQuery=true)
    public int getAprobadas(int idexpediente);

    @Query(value="SELECT COUNT(me.nota) AS Reprobadas\n" +
            "FROM public.expediente ex INNER JOIN public.materiaexpediente me ON ex.idexpediente=me.idexpediente\n" +
            "INNER JOIN public.materia m ON me.idmateria=m.idmateria\n" +
            "WHERE ex.idexpediente=? AND me.nota<6.0", nativeQuery=true)
    public int getReprobadas(int idexpediente);

    @Query(value="SELECT CAST(AVG(me.nota) AS numeric(2,1)) AS Promedio\n" +
            "FROM public.expediente ex INNER JOIN public.materiaexpediente me ON ex.idexpediente=me.idexpediente\n" +
            "INNER JOIN public.materia m ON me.idmateria=m.idmateria\n" +
            "WHERE ex.idexpediente=?;", nativeQuery=true)
    public Number getPromedio(int idexpediente);

}
