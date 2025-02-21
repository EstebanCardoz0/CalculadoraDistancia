package org.example.calculadoradistancia.service;

import org.example.calculadoradistancia.entity.Distancia;

import java.util.List;

public interface IDistanciaService {

    String crearDistancia(Distancia distancia);

    List<Distancia> getDistancias();

    List<Distancia> getDistanciasPorKM();

    Distancia getDistancia(Integer id);

    String deleteDistancia(Integer id);

    void editDistancia(Integer id, Double nKilómetros, String nCiudad_A, String nCiudad_B);
}
