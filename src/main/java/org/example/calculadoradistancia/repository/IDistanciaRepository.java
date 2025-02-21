package org.example.calculadoradistancia.repository;

import org.example.calculadoradistancia.entity.Ciudad;
import org.example.calculadoradistancia.entity.Distancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDistanciaRepository extends
        JpaRepository<Distancia, Integer> {

    @Query("SELECT d FROM Distancia d " +
            "WHERE (d.ciudad_A = :ciudadA AND d" +
            ".ciudad_B = :ciudadB) " +
            "   OR (d.ciudad_A = :ciudadB AND d" +
            ".ciudad_B = :ciudadA)")
    Optional<Distancia> findByCiudades(
            @Param("ciudadA") Ciudad ciudadA,
            @Param("ciudadB") Ciudad ciudadB);

    List<Distancia> findByOrderByKilómetrosDesc();


}
