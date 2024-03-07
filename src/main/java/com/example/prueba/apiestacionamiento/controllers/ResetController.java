package com.example.prueba.apiestacionamiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.apiestacionamiento.services.IResetService;

@RestController
@RequestMapping("/reiniciar")
public class ResetController {

    @Autowired
    private IResetService resetService;

    @GetMapping("/mes")
    public ResponseEntity<String> reiniciarValores(){
        resetService.eliminarOficiales();
        resetService.inicioEnCero();
        return ResponseEntity.ok("");
    }

}
