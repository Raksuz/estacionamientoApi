package com.example.prueba.apiestacionamiento.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "registroEstancia")
public class Estancia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_auto")
    private Vehiculo vehiculo;

    private LocalDateTime entrada;
    private LocalDateTime salida;
    private long tiempo;
    private double importe;
}
