package com.example.prueba.apiestacionamiento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.prueba.apiestacionamiento.entities.Estancia;

@Repository
public interface InformeRepository extends JpaRepository<Estancia, Integer>{
    @Query("SELECT e.vehiculo.numPlaca, sum(e.tiempo),CASE WHEN e.vehiculo.tipo = 'RESIDENTE' THEN SUM(e.tiempo * 0.05) END AS Cantidad FROM Estancia e WHERE e.vehiculo.tipo IN ('RESIDENTE') GROUP BY e.vehiculo.numPlaca")
    List<Object[]> obtenerDetalle();
}
