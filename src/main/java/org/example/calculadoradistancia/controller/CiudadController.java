package org.example.calculadoradistancia.controller;

import org.example.calculadoradistancia.entity.Ciudad;
import org.example.calculadoradistancia.service.CiudadService;
import org.example.calculadoradistancia.service.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/ciudad")
public class CiudadController {

    @Autowired ICiudadService ciudadServ;

    @PostMapping("/crear")
    public String crearCiudad(@RequestBody
                              Ciudad ciudad) {
        System.out.println("datos " +
                "recibidos: " + ciudad);
        ciudadServ.crearCiudad(ciudad);
        return "Ciudad creada exitosamente";
    }

    @GetMapping("/get")
    public List<Ciudad> getCiudades() {

        return ciudadServ.getCiudades();
    }

}
