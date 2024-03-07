package com.example.prueba.apiestacionamiento.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.apiestacionamiento.entities.Estancia;
import com.example.prueba.apiestacionamiento.entities.TipoVehiculo;
import com.example.prueba.apiestacionamiento.entities.Vehiculo;
import com.example.prueba.apiestacionamiento.repositories.IEstanciaRepository;
import com.example.prueba.apiestacionamiento.repositories.IVehiculoRepository;

@Service
public class EstanciaServiceImp implements IEstanciaService {

    @Autowired
    private IVehiculoRepository vehiculoRepository;

    @Autowired
    private IEstanciaRepository estanciaRepository;

    @Override
    public Estancia registrarEntrada(String numplaca) {
        Vehiculo vehiculo = vehiculoRepository.findByNumPlaca(numplaca);
        if (vehiculo == null) {
            return null;
        } else {
            Estancia registro = new Estancia();
            registro.setVehiculo(vehiculo);
            registro.setEntrada(LocalDateTime.now());
            return estanciaRepository.save(registro);
        }
    }

    @Override
    public Estancia registrarSalida(String numPlaca) {
        Vehiculo vehiculo = vehiculoRepository.findByNumPlaca(numPlaca);
        if (vehiculo == null) {
            System.out.println("No existe un vehiculo");
            return null;
        }
        List<Estancia> registroSinSalida = estanciaRepository.findByVehiculo(vehiculo);
        if (registroSinSalida.isEmpty()) {
            System.out.println("No existe ningun registro de entrada");
            return null;
        }
        Estancia registroEntrada = registroSinSalida.get(0);
        registroEntrada.setSalida(LocalDateTime.now());
        registroEntrada.setTiempo(tiempoEstancia(registroEntrada.getEntrada(), registroEntrada.getSalida()));
        estanciaRepository.save(registroEntrada);
        var recu = vehiculo.getTipo();
        if (recu == TipoVehiculo.NORESIDENTE) {
            double tarifaNoResidente = 0.5;
            registroEntrada.setImporte(registroEntrada.getTiempo() * tarifaNoResidente);
            return estanciaRepository.save(registroEntrada);
        }
        return registroEntrada;
    }

    @Override
    public long tiempoEstancia(LocalDateTime entrada, LocalDateTime salida) {
        Duration duration = Duration.between(entrada, salida);
        return duration.toMinutes();
    }

}
