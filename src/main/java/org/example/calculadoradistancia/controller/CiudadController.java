package org.example.calculadoradistancia.controller;

import org.example.calculadoradistancia.dto.CiudadDTO;
import org.example.calculadoradistancia.entity.Ciudad;
import org.example.calculadoradistancia.entity.Distancia;
import org.example.calculadoradistancia.service.CiudadService;
import org.example.calculadoradistancia.service.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public List<CiudadDTO> getCiudades() {

        List<CiudadDTO> ciudades =
                new ArrayList<>();


        for (Ciudad ciu :
                ciudadServ.getCiudades()) {

            Set<String> vincu = new HashSet<>();


            for (Distancia lista :
                    ciu.getDistancias()) {
                if (!lista.getCiudad_A()
                        .equals(ciu)
                ) {
                    vincu.add(lista.getCiudad_A()
                            .getNombre());
                }
                if (!lista.getCiudad_B()
                        .equals(ciu)
                ) {
                    vincu.add(lista.getCiudad_B()
                            .getNombre());
                }
            }

            ciudades.add(new CiudadDTO(
                    ciu.getCiudadId(),
                    ciu.getNombre(),
                    ciu.getRegion(),
                    ciu.getHabitantes(),
                    new ArrayList<String>(
                            vincu)));

        }

        return ciudades;
    }

}
