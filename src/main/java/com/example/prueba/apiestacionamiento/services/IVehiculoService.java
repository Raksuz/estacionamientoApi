package com.example.prueba.apiestacionamiento.services;

import java.util.List;

import com.example.prueba.apiestacionamiento.entities.Vehiculo;

public interface IVehiculoService {

    List<Vehiculo> obtenerTodosLosVehiculos();

    Vehiculo registrarOficial(Vehiculo vehiculo);
    Vehiculo registrarResidente(Vehiculo vehiculo);
    Vehiculo registrarNoResidente(Vehiculo vehiculo);
}
