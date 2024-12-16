package org.example.calculadoradistancia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ValueGenerationType;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Distancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDistancia;
    private Double kilómetros;
    @ManyToOne
    @JoinColumn(name = "ciudad_A")
    private Ciudad ciudad_A;
    @ManyToOne
    @JoinColumn(name = "ciudad_B")
    private Ciudad ciudad_B;

}
