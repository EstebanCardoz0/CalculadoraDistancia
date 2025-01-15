package org.example.calculadoradistancia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import org.example.calculadoradistancia.entity.Distancia;

import java.util.List;

public class CiudadDTO {

    private Integer ciudadId;
    private String nombre;
    private String region;
    private long habitantes;
    private List<String> vinculos;

    public CiudadDTO() {
    }

    public CiudadDTO(Integer ciudadId,
                     String nombre,
                     String region,
                     long habitantes,
                     List<String> vinculos) {
        this.ciudadId = ciudadId;
        this.nombre = nombre;
        this.region = region;
        this.habitantes = habitantes;
        this.vinculos = vinculos;
    }

    public Integer getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Integer ciudadId) {
        this.ciudadId = ciudadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public long getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(long habitantes) {
        this.habitantes = habitantes;
    }

    public List<String> getVinculos() {
        return vinculos;
    }

    public void setVinculos(
            List<String> vinculos) {
        this.vinculos = vinculos;
    }
}
