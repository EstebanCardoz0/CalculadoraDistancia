package org.example.calculadoradistancia.controller;

import org.example.calculadoradistancia.dto.DistanciaDTO;
import org.example.calculadoradistancia.entity.Distancia;
import org.example.calculadoradistancia.service.IDistanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/distancia")
public class DistanciaController {

    @Autowired
    IDistanciaService
            distanciaServ;

    @PostMapping("/crear")
    public String crearDistancia(
            @RequestBody Distancia distancia) {

        String mensaje = distanciaServ.crearDistancia(distancia);

        return mensaje;
    }

    @GetMapping("/get")
    public List<DistanciaDTO> getDistancias() {

        List<Distancia> disti = distanciaServ.getDistancias();
        List<DistanciaDTO> dis = new ArrayList<>();

        for (Distancia d : disti) {

            dis.add(new DistanciaDTO(d.getIdDistancia(), d.getKilómetros(), d.getCiudad_A().getNombre(),
                    d.getCiudad_B().getNombre()));
        }

        return dis;
    }

    @GetMapping("/get/{id}")
    public DistanciaDTO getDistancia(@PathVariable Integer id) {
        Distancia disti = distanciaServ.getDistancia(id);
        return new DistanciaDTO(disti.getIdDistancia(), disti.getKilómetros(),
                disti.getCiudad_A().getNombre(), disti.getCiudad_B().getNombre());

    }

    @DeleteMapping("/delete/{id}")
    public String deleteDistancia(@PathVariable Integer id) {

        return distanciaServ.deleteDistancia(id);
    }


}
