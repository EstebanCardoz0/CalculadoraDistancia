package org.example.calculadoradistancia.service;

import org.example.calculadoradistancia.entity.Ciudad;
import org.example.calculadoradistancia.exception.ResourceNotFoundException;
import org.example.calculadoradistancia.repository.ICiudadRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


@Service
public class CiudadService implements ICiudadService {

    @Autowired
    ICiudadRepository ciudadRepo;

    private static final Logger logger = LoggerFactory.getLogger(CiudadService.class);

    @Override
    public String crearCiudad(Ciudad ciudad) {


        if (ciudad.getNombre() != null && ciudad.getRegion() != null) {

            ciudad.setDistanciasA(new ArrayList<>());
            ciudad.setDistanciasB(new ArrayList<>());
            ciudadRepo.save(ciudad);
            String mensaje = "Ciudad creada con éxito";
            logger.info(mensaje);
            return mensaje;

        } else {
            String mensaje = "Falta uno o más datos";
            logger.error(mensaje);
            return mensaje;

        }


    }

    @Override
    public List<Ciudad> getCiudades() {

        List<Ciudad> ciudades = ciudadRepo.findAll();

        if (ciudades.isEmpty()) {
            throw new ResourceNotFoundException("No hay ciudades registradas");
        }

        return ciudades;
    }

    @Override
    public Ciudad getCiudad(Integer id) {

        return ciudadRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No se encontró ciudad con ese ID"));

    }

    @Override
    public String deleteCiudad(Integer id) {

        for (Ciudad ciu : this.ciudadRepo.findAll()) {

            if (!ciudadRepo.existsById(id)) {
                throw new ResourceNotFoundException("No se encontró ciudad con ese ID");
            }
        }
        ciudadRepo.deleteById(id);
        return "Ciudad eliminada con éxito";
    }

    @Override
    public void editCiudad(Integer id, String Nnombre, String Nregion, long Nhabitantes) {
        Ciudad ciu = this.getCiudad(id);
        ciu.setNombre(Nnombre);
        ciu.setRegion(Nregion);
        ciu.setHabitantes(Nhabitantes);
        ciudadRepo.save(ciu);
    }
}
