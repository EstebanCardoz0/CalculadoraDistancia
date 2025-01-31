package org.example.calculadoradistancia.service;

import jakarta.transaction.Transactional;
import org.example.calculadoradistancia.entity.Ciudad;
import org.example.calculadoradistancia.entity.Distancia;
import org.example.calculadoradistancia.exception.ResourceNotFoundException;
import org.example.calculadoradistancia.repository.ICiudadRepository;
import org.example.calculadoradistancia.repository.IDistanciaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistanciaService
        implements IDistanciaService {

    @Autowired
    IDistanciaRepository distanciaRepo;
    @Autowired
    ICiudadRepository ciudadRepo;

    private static final Logger logger = LoggerFactory.getLogger(DistanciaService.class);

    @Override
    @Transactional
    public java.lang.String crearDistancia(Distancia distancia) {

        Ciudad A = ciudadRepo.findById(distancia.getCiudad_A().getCiudadId()).orElse(null);
        Ciudad B = ciudadRepo.findById(distancia.getCiudad_B().getCiudadId()).orElse(null);

        if (A != null && B != null && distancia.getKilómetros() != null) {

            Optional<Distancia> existente = distanciaRepo.findByCiudades(A, B);

            if (existente.isEmpty()) {
                distancia.setCiudad_A(A);
                distancia.setCiudad_B(B);
                distanciaRepo.save(distancia);
            } else {
                java.lang.String mensaje = "La distancia entre ciudades ya existe";
                logger.error(mensaje);

                return mensaje;
            }

        } else {
            java.lang.String mensaje = "Una o ambas ciudades no están en la base de datos, o el kilómetro es null";
            logger.error(mensaje);

            return mensaje;

        }

        java.lang.String mensaje = "Distancia creada correctamente.";
        logger.info(mensaje);

        return mensaje;
    }

    @Override
    public List<Distancia> getDistancias() {

        return distanciaRepo.findAll();
    }

    @Override
    public Distancia getDistancia(Integer id) {

        return distanciaRepo.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("No se encontró distancia con ese ID"));
    }

    @Override
    public String deleteDistancia(Integer id) {
        if (!distanciaRepo.existsById(id)) {
            throw new ResourceNotFoundException("No se encontró distancia con ese ID");
        }
        distanciaRepo.deleteById(id);

        return "Distancia eliminada con éxito";
    }
}
