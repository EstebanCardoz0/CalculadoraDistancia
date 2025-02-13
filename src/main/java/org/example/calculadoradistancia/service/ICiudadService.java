package org.example.calculadoradistancia.service;

import org.example.calculadoradistancia.entity.Ciudad;

import java.util.List;

public interface ICiudadService {

    String crearCiudad(Ciudad ciudad);

    List<Ciudad> getCiudades();

    Ciudad getCiudad(Integer id);

    String deleteCiudad(Integer id);

    void editCiudad(Integer id, String Nnombre, String Nregion, long Nhabitantes);


}
