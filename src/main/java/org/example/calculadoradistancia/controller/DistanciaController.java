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

        return this.convertirADTO(distanciaServ.getDistanciasPorKM());
    }

    @GetMapping("/getKM")
    public List<DistanciaDTO> getDistanciasPorKM() {

        return this.convertirADTO(distanciaServ.getDistanciasPorKM());
    }

    private List<DistanciaDTO> convertirADTO(List<Distancia> disti) {

        List<DistanciaDTO> dis = new ArrayList<>();
        for (Distancia dist : disti) {
            dis.add(new DistanciaDTO(dist.getIdDistancia(), dist.getKilómetros(), dist.getCiudad_A().getNombre(),
                    dist.getCiudad_B().getNombre()));
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

    @PutMapping("/edit/{id}")
    public DistanciaDTO editDistancia(@PathVariable Integer id, @RequestParam(required = false, name =
            "kilómetros") Double nKilometros, @RequestParam(required = false, name = "ciudad_A") String nCiudad_A,
                                      @RequestParam(required = false, name = "ciudad_B") String nCiudad_B) {

        distanciaServ.editDistancia(id, nKilometros, nCiudad_A, nCiudad_B);
        return this.getDistancia(id);

    }


}
