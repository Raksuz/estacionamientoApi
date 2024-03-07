package com.example.prueba.apiestacionamiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.apiestacionamiento.entities.Estancia;
import com.example.prueba.apiestacionamiento.services.IEstanciaService;

@RestController
@RequestMapping("/api/registro")
public class EstanciaController {

    @Autowired
    private IEstanciaService estanciaService;

    @PostMapping("/entrada")
    public ResponseEntity<Estancia> registroEntrada(@RequestBody String numplaca){
        Estancia guardarHoraEntrada = estanciaService.registrarEntrada(numplaca);
        return new ResponseEntity<>(guardarHoraEntrada, HttpStatus.CREATED);
    }

    @PostMapping("/salida")
    public ResponseEntity<Estancia> registroSalida(@RequestBody String numplaca){
        Estancia guardarHoraSalida = estanciaService.registrarSalida(numplaca);
        return new ResponseEntity<>(guardarHoraSalida, HttpStatus.CREATED);
    }
}
