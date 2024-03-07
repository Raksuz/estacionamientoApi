package com.example.prueba.apiestacionamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.apiestacionamiento.services.InformeService;

@RestController
@RequestMapping("/informe")
public class InformeController {

    @Autowired
    private InformeService informeService;

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> pruebaPDF(){
        List<Object[]> datos = informeService.obtenerDetalle();
        byte[] pdfBytes = informeService.generarPDF(datos);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", "prueba.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}
