package com.example.prueba.apiestacionamiento.services;

import org.springframework.stereotype.Service;

@Service
public interface IResetService {
    void eliminarOficiales();
    void inicioEnCero();
}
