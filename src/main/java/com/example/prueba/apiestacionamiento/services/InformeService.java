package com.example.prueba.apiestacionamiento.services;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface InformeService {
    List<Object[]> obtenerDetalle();
    byte[] generarPDF(List<Object[]> datos);
}
