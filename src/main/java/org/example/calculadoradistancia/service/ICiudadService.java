package org.example.calculadoradistancia.service;

import org.example.calculadoradistancia.entity.Ciudad;

import java.util.List;
import java.util.Map;

public interface ICiudadService {

    String crearCiudad(Ciudad ciudad);

    List<Ciudad> getCiudades();

    Ciudad getCiudad(Integer id);

    String deleteCiudad(Integer id);

    void editCiudad(Integer id, String Nnombre, String Nregion, long Nhabitantes);

    Map<String,Ciudad> findCercanaAlejada (Integer ciudadId);


}
