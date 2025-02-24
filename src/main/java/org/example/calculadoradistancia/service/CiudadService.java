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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @Override
    public Map<String, Ciudad> findCercanaAlejada(Integer ciudadId) {

        List<Object[]> distanciasRelacionadas = ciudadRepo.findDistanciasRelacionadas(ciudadId);

        Ciudad masCercana = null;
        Ciudad masLejana = null;
        double distanciaMin = Double.MIN_VALUE;
        double distanciaMax = Double.MAX_VALUE;

        for (Object[] resultado : distanciasRelacionadas) {
            Ciudad otraCiudad = (Ciudad) resultado[0];
            double kilometros = (Double) resultado[1];

            if (kilometros < distanciaMin) {
                distanciaMin = kilometros;
                masCercana = otraCiudad;
            }
            if (kilometros > distanciaMax) {
                distanciaMax = kilometros;
                masLejana = otraCiudad;
            }
        }

        if (masCercana == null || masLejana == null) {
            throw new ResourceNotFoundException("No se encontraron ciudades relacionadas");
        }

        Map<String, Ciudad> resultado = new HashMap<>();
        resultado.put("masCercana", masCercana);
        resultado.put("masLejana", masLejana);

        return resultado;
    }
}
