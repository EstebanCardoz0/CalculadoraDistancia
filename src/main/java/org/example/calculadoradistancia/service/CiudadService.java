package org.example.calculadoradistancia.service;

import org.example.calculadoradistancia.entity.Ciudad;
import org.example.calculadoradistancia.repository.ICiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static sun.jvm.hotspot.HelloWorld.e;

@Service
public class CiudadService
        implements ICiudadService {

    @Autowired
    ICiudadRepository ciudadRepo;

    @Override
    public void crearCiudad(Ciudad ciudad) {

        try {

            if (ciudad.getNombre() == null  ||
                    ciudad.getRegion()==null || ciudad.getDistanciasA()==null || ciudad.getDistanciasB()==null)
                throw new IllegalArgumentException("falta uno o más datos");


                ciudad.setDistanciasA(new ArrayList<>());
            ciudad.setDistanciasB(new ArrayList<>());
            ciudadRepo.save(ciudad);
        } catch (Exception e) {

        }


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
