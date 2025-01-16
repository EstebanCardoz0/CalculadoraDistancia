package org.example.calculadoradistancia.dto;

import org.example.calculadoradistancia.entity.Ciudad;

public class DistanciaDTO {

    private Integer idDistancia;
    private Double kilómetros;
    private String ciudad_A;
    private String ciudad_B;


    public DistanciaDTO() {
    }

    public DistanciaDTO(Integer idDistancia, Double kilómetros, String ciudad_A, String ciudad_B) {
        this.idDistancia = idDistancia;
        this.kilómetros = kilómetros;
        this.ciudad_A = ciudad_A;
        this.ciudad_B = ciudad_B;
    }

    public Integer getIdDistancia() {
        return idDistancia;
    }

    public void setIdDistancia(Integer idDistancia) {
        this.idDistancia = idDistancia;
    }

    public Double getKilómetros() {
        return kilómetros;
    }

    public void setKilómetros(Double kilómetros) {
        this.kilómetros = kilómetros;
    }

    public String getCiudad_A() {
        return ciudad_A;
    }

    public void setCiudad_A(String ciudad_A) {
        this.ciudad_A = ciudad_A;
    }

    public String getCiudad_B() {
        return ciudad_B;
    }

    public void setCiudad_B(String ciudad_B) {
        this.ciudad_B = ciudad_B;
    }
}
