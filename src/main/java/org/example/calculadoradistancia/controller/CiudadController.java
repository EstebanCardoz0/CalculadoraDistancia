package org.example.calculadoradistancia.controller;

import org.example.calculadoradistancia.dto.CiudadDTO;
import org.example.calculadoradistancia.entity.Ciudad;
import org.example.calculadoradistancia.entity.Distancia;
import org.example.calculadoradistancia.service.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {

    @Autowired
    ICiudadService ciudadServ;

    @PostMapping("/crear")
    public String crearCiudad(@RequestBody Ciudad ciudad) {

        return ciudadServ.crearCiudad(ciudad);
    }

    @GetMapping("/get")
    public List<CiudadDTO> getCiudades() {

        List<CiudadDTO> ciudades =
                new ArrayList<>();

        for (Ciudad ciu :
                ciudadServ.getCiudades()) {

            Set<java.lang.String> vincu = new HashSet<>();

            for (Distancia lista :
                    ciu.allDistancias()) {
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
                    new ArrayList<java.lang.String>(
                            vincu)));
        }
        return ciudades;
    }

    @GetMapping("/get/{id}")
    public CiudadDTO getCiudad(@PathVariable Integer id) {
        Ciudad ciudad = ciudadServ.getCiudad(id);
        Set<java.lang.String> vincu = new HashSet<>();

        for (Distancia dis : ciudad.allDistancias()) {
            if (!dis.getCiudad_A().equals(ciudad)) {
                vincu.add(dis.getCiudad_A().getNombre());
            }
            if (!dis.getCiudad_B().equals(ciudad)) {
                vincu.add(dis.getCiudad_B().getNombre());
            }
        }


        CiudadDTO ciu = new CiudadDTO(ciudad.getCiudadId(), ciudad.getNombre(), ciudad.getRegion(),
                ciudad.getHabitantes(), new ArrayList<>(vincu));
        return ciu;
    }

}
