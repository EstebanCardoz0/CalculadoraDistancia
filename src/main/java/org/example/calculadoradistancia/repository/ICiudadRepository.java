package org.example.calculadoradistancia.repository;

import org.example.calculadoradistancia.entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Integer> {

    Ciudad findByNombre(String nombre);

    List<Ciudad> findByOrderByHabitantesDesc();

    @Query("select d.ciudad_B, d.kilómetros from Distancia d where d.ciudad_A.ciudadId = :ciudadId " +
            "union all " + "select d.ciudad_A, d.kilómetros from Distancia d where d.ciudad_B.ciudadId = :ciudadId")
    List<Object[]> findDistanciasRelacionadas(@Param("ciudadId") Integer ciudadId);

}
