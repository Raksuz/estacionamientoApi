package com.example.prueba.apiestacionamiento.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba.apiestacionamiento.entities.Vehiculo;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Integer> {
    Vehiculo findByNumPlaca(String numPlaca);
}
