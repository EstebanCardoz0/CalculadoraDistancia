package org.example.calculadoradistancia.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(
        generator =
                ObjectIdGenerators.PropertyGenerator.class,
        property = "idDistancia")

public class Distancia {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Integer idDistancia;
    @JsonProperty("kilómetros")
    private Double kilómetros;
    @ManyToOne
    @JoinColumn(name = "ciudad_A",
            nullable = false)
    @JsonProperty("ciudad_A")
    private Ciudad ciudad_A;
    @ManyToOne
    @JoinColumn(name = "ciudad_B",
            nullable = false)
    @JsonProperty("ciudad_B")
    private Ciudad ciudad_B;

    public Distancia(Integer idDistancia,
                     Double kilómetros,
                     Ciudad ciudad_A,
                     Ciudad ciudad_B) {
        this.idDistancia = idDistancia;
        this.kilómetros = kilómetros;
        this.ciudad_A = ciudad_A;
        this.ciudad_B = ciudad_B;
    }

    public Distancia() {
    }

    public Integer getIdDistancia() {
        return idDistancia;
    }

    public void setIdDistancia(
            Integer idDistancia) {
        this.idDistancia = idDistancia;
    }

    public Double getKilómetros() {
        return kilómetros;
    }

    public void setKilómetros(Double kilómetros) {
        this.kilómetros = kilómetros;
    }

    public Ciudad getCiudad_A() {
        return ciudad_A;
    }

    public void setCiudad_A(
            Ciudad ciudad_A) {
        this.ciudad_A = ciudad_A;
    }

    public Ciudad getCiudad_B() {
        return ciudad_B;
    }

    public void setCiudad_B(
            Ciudad ciudad_B) {
        this.ciudad_B = ciudad_B;
    }

    @Override
    public java.lang.String toString() {
        return "Distancia{" +
                "idDistancia=" + idDistancia +
                ", kilómetros=" + kilómetros +
                ", ciudad_A=" + ciudad_A +
                ", ciudad_B=" + ciudad_B +
                '}';
    }
}
