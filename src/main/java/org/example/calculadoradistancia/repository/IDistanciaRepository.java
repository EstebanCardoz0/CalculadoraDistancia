package org.example.calculadoradistancia.repository;

import org.example.calculadoradistancia.entity.Distancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDistanciaRepository extends
        JpaRepository <Distancia, Integer> {
}
