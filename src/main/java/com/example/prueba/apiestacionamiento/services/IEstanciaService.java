package com.example.prueba.apiestacionamiento.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.prueba.apiestacionamiento.entities.Estancia;

@Service
public interface IEstanciaService { 
    Estancia registrarEntrada(String numPlaca);
    Estancia registrarSalida(String numPlaca);
    long tiempoEstancia(LocalDateTime entrada, LocalDateTime salida);
}
