package org.example.calculadoradistancia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ciudadId;
    private String nombre;
    private String region;
    private long habitantes;
    @ManyToMany
    @JoinTable(name = "distancia", joinColumns = @JoinColumn(name = "ciudad_A"), inverseJoinColumns =
    @JoinColumn(name = "ciudad_B"))
    private List<Ciudad> distancias;
}
