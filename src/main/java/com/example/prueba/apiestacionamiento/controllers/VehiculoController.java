package com.example.prueba.apiestacionamiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.apiestacionamiento.entities.Vehiculo;
import com.example.prueba.apiestacionamiento.services.IVehiculoService;

@RestController
@RequestMapping("/api/registro/vehiculo")
public class VehiculoController {

    @Autowired
    IVehiculoService vehiculoService;

    @PostMapping("/oficial")
    public ResponseEntity<Vehiculo> registroVehiculoOficial(@RequestBody Vehiculo vehiculo){
        Vehiculo guardarVehiculo = vehiculoService.registrarOficial(vehiculo);
        return new ResponseEntity<>(guardarVehiculo, HttpStatus.CREATED);
    }

    @PostMapping("/residente")
    public ResponseEntity<Vehiculo> registroVehiculoResidente(@RequestBody Vehiculo vehiculo){
        Vehiculo guardarVehiculo = vehiculoService.registrarResidente(vehiculo);
        return new ResponseEntity<>(guardarVehiculo, HttpStatus.CREATED);
    }

    @PostMapping("/noresidente")
    public ResponseEntity<Vehiculo> registroVehiculoNoResidente(@RequestBody Vehiculo vehiculo){
        Vehiculo guardarVehiculo = vehiculoService.registrarNoResidente(vehiculo);
        return new ResponseEntity<>(guardarVehiculo, HttpStatus.CREATED);
    }
}
