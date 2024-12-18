package org.example.calculadoradistancia.service;

import jakarta.transaction.Transactional;
import org.example.calculadoradistancia.entity.Ciudad;
import org.example.calculadoradistancia.entity.Distancia;
import org.example.calculadoradistancia.repository.ICiudadRepository;
import org.example.calculadoradistancia.repository.IDistanciaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanciaService
        implements IDistanciaService {

    @Autowired IDistanciaRepository distanciaRepo;
    @Autowired ICiudadRepository ciudadRepo;

    private static final Logger logger =
            LoggerFactory.getLogger(
                    DistanciaService.class);


    @Override @Transactional
    public void crearDistancia(
            Distancia distancia) {

        Ciudad A =
                ciudadRepo.findById(
                                distancia.getCiudad_A()
                                        .getCiudadId())
                        .orElse(null);
        Ciudad B =
                ciudadRepo.findById(
                                distancia.getCiudad_B()
                                        .getCiudadId())
                        .orElse(null);

        if (A != null && B != null) {
            distanciaRepo.save(distancia);
            A.getDistancias()
                    .add(distancia.getCiudad_B());
            B.getDistancias()
                    .add(distancia.getCiudad_A());
            ciudadRepo.save(A);
            ciudadRepo.save(B);
        } else {
            logger.error(
                    "Una o ambas ciudades no " +
                            "están en la base " +
                            "de datos");

        }


    }
}
