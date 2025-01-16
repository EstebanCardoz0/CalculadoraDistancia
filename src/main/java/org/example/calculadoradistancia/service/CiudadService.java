package org.example.calculadoradistancia.service;

import org.example.calculadoradistancia.entity.Ciudad;
import org.example.calculadoradistancia.entity.Distancia;
import org.example.calculadoradistancia.repository.ICiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadService
        implements ICiudadService {

    @Autowired
    ICiudadRepository ciudadRepo;

    @Override
    public void crearCiudad(Ciudad ciudad) {

        ciudad.setDistancias(
                new ArrayList<Distancia>());
        ciudadRepo.save(ciudad);


    }

    @Override
    public List<Ciudad> getCiudades() {

        return ciudadRepo.findAll();
    }

    @Override
    public Ciudad getCiudad(Integer id) {

        return ciudadRepo.findById(id).orElse(null);
    }
}
