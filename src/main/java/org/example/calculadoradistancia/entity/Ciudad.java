package org.example.calculadoradistancia.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private List<Distancia> distancias;

    public Ciudad() {
    }

    public Ciudad(Integer ciudadId, String nombre,
                  String region, long habitantes,
                  List<Distancia> distancias) {
        this.ciudadId = ciudadId;
        this.nombre = nombre;
        this.region = region;
        this.habitantes = habitantes;
        this.distancias = distancias;
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

    public List<Distancia> getDistancias() {
        return distancias;
    }

    public void setDistancias(
            List<Distancia> distancias) {
        this.distancias = distancias;
    }

    @Override public String toString() {
        return "Ciudad{" +
                "ciudadId=" + ciudadId +
                ", nombre='" + nombre + '\'' +
                ", region='" + region + '\'' +
                ", habitantes=" + habitantes +
                ", distancias=" + distancias +
                '}';
    }
}
