package org.example.calculadoradistancia.controller;

import org.example.calculadoradistancia.entity.Distancia;
import org.example.calculadoradistancia.service.IDistanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/distancia")
public class DistanciaController {

    @Autowired IDistanciaService
            distanciaServ;

    @PostMapping("/crear")
    public String crearDistancia(@RequestBody
                                 Distancia distancia) {
        System.out.println(
                "Datos recibidos: " + distancia);
        distanciaServ.crearDistancia(distancia);

        return "Distancia creada con éxito";
    }


}
