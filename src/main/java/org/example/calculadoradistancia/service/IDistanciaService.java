package org.example.calculadoradistancia.service;

import org.example.calculadoradistancia.entity.Distancia;

import java.util.List;

public interface IDistanciaService {

    String crearDistancia(Distancia distancia);
    List<Distancia> getDistancias();
    Distancia getDistancia(Integer id);
    String deleteDistancia(Integer id);
}
