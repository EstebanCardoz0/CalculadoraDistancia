package org.example.calculadoradistancia.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
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
    @ManyToMany
    @JoinTable(name = "distancia",
            joinColumns = @JoinColumn(
                    name = "ciudad_A"),
            inverseJoinColumns =
            @JoinColumn(name = "ciudad_B"))
    private List<Ciudad> distancias;

    public Ciudad() {
    }

    public Ciudad(Integer ciudadId, String nombre,
                  String region, long habitantes,
                  List<Ciudad> distancias) {
        this.ciudadId = ciudadId;
        this.nombre = nombre;
        this.region = region;
        this.habitantes = habitantes;
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

    public List<Ciudad> getDistancias() {
        return distancias;
    }

    public void setDistancias(
            List<Ciudad> distancias) {
        this.distancias = distancias;
    }
}
