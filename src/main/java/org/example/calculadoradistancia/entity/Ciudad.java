package org.example.calculadoradistancia.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ciudadId")

public class Ciudad {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Integer ciudadId;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("region")
    private String region;
    @JsonProperty("habitantes")
    private long habitantes;
    @OneToMany(mappedBy = "ciudad_A", cascade =
            CascadeType.ALL)
    private List<Distancia> distanciasA;
    @OneToMany(mappedBy = "ciudad_B", cascade =
            CascadeType.ALL)
    private List<Distancia> distanciasB;

    public List<Distancia> allDistancias() {
        List<Distancia> allDistancias = new ArrayList<>();
        allDistancias.addAll(distanciasA);
        allDistancias.addAll(distanciasB);
        return allDistancias;
    }

    public Ciudad() {
    }

    public Ciudad(Integer ciudadId, String nombre, String region, long habitantes, List<Distancia> distanciasA, List<Distancia> distanciasB) {
        this.ciudadId = ciudadId;
        this.nombre = nombre;
        this.region = region;
        this.habitantes = habitantes;
        this.distanciasA = distanciasA;
        this.distanciasB = distanciasB;
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

    public List<Distancia> getDistanciasA() {
        return distanciasA;
    }

    public void setDistanciasA(List<Distancia> distanciasA) {
        this.distanciasA = distanciasA;
    }

    public List<Distancia> getDistanciasB() {
        return distanciasB;
    }

    public void setDistanciasB(List<Distancia> distanciasB) {
        this.distanciasB = distanciasB;
    }
}
