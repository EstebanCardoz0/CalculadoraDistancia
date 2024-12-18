package org.example.calculadoradistancia.repository;

import org.example.calculadoradistancia.entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICiudadRepository extends
        JpaRepository<Ciudad, Integer> {
}
