package org.example.calculadoradistancia.service;

import org.example.calculadoradistancia.entity.Ciudad;
import org.example.calculadoradistancia.repository.ICiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CiudadService
        implements ICiudadService {

    @Autowired ICiudadRepository ciudadRepo;

    @Override
    public void crearCiudad(Ciudad ciudad) {

        ciudad.setDistancias(new ArrayList<Ciudad>());
        ciudadRepo.save(ciudad);


    }
}
