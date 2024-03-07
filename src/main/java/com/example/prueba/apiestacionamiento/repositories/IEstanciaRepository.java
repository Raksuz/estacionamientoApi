package com.example.prueba.apiestacionamiento.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.prueba.apiestacionamiento.entities.Estancia;
import com.example.prueba.apiestacionamiento.entities.Vehiculo;

@Repository
public interface IEstanciaRepository extends JpaRepository<Estancia, Integer>{

    @Query("SELECT e FROM Estancia e WHERE e.vehiculo = :vehiculo AND e.salida IS NULL")
   List<Estancia> findByVehiculo(@Param("vehiculo") Vehiculo vehiculo);
}
