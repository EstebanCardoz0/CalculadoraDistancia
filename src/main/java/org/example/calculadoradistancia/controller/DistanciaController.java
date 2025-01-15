package org.example.calculadoradistancia.controller;

import org.example.calculadoradistancia.entity.Distancia;
import org.example.calculadoradistancia.service.IDistanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/distancia")
public class DistanciaController {

    @Autowired IDistanciaService
            distanciaServ;

    @PostMapping("/crear")
    public String crearDistancia(
            @RequestBody Distancia distancia) {

        String mensaje =
                distanciaServ.crearDistancia(
                        distancia);

        return mensaje;
    }

    @GetMapping("/get")
    public List<Distancia> getDistancias() {
        return distanciaServ.getDistancias();
    }


}
