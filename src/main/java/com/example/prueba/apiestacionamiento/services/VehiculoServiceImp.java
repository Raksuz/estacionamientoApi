package com.example.prueba.apiestacionamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.apiestacionamiento.entities.TipoVehiculo;
import com.example.prueba.apiestacionamiento.entities.Vehiculo;
import com.example.prueba.apiestacionamiento.repositories.IVehiculoRepository;
@Service
public class VehiculoServiceImp implements IVehiculoService {

    @Autowired
    private IVehiculoRepository vehiculoRepo;

    @Override
    public List<Vehiculo> obtenerTodosLosVehiculos() {
        return vehiculoRepo.findAll();
    }

    @Override
    public Vehiculo registrarOficial(Vehiculo vehiculo) {
        vehiculo.setTipo(TipoVehiculo.OFICIAL);
        return vehiculoRepo.save(vehiculo);
    }

    @Override
    public Vehiculo registrarResidente(Vehiculo vehiculo) {
        vehiculo.setTipo(TipoVehiculo.RESIDENTE);
        return vehiculoRepo.save(vehiculo);
    }

    @Override
    public Vehiculo registrarNoResidente(Vehiculo vehiculo) {
        vehiculo.setTipo(TipoVehiculo.NORESIDENTE);
        return vehiculoRepo.save(vehiculo);
    }

}
