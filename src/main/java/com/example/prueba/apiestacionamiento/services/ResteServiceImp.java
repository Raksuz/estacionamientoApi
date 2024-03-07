package com.example.prueba.apiestacionamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.apiestacionamiento.entities.Estancia;
import com.example.prueba.apiestacionamiento.repositories.IResetRepository;

@Service
public class ResteServiceImp implements IResetService {

    @Autowired
    private IResetRepository resetRepository;

    @Override
    public void eliminarOficiales() {
        resetRepository.eliminarOficiales();
    }

    @Override
    public void inicioEnCero() {
        List<Estancia> datos = resetRepository.findResidentes();
        if(datos.isEmpty()) {
            System.out.println("vacio");
        } else {
            for (int i = 0; i < datos.size(); i++) {
                Estancia residentes = datos.get(i);
                long timeReset = 0;
                residentes.setTiempo(timeReset);
                resetRepository.save(residentes);
            }
        }
    }

}
