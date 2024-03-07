package com.example.prueba.apiestacionamiento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.prueba.apiestacionamiento.entities.Estancia;

@Repository
public interface IResetRepository extends JpaRepository<Estancia, Integer>{
    @Transactional
    @Modifying
    @Query("DELETE FROM Estancia e WHERE e.vehiculo.tipo = 'OFICIAL'")
    void eliminarOficiales();

    @Query("SELECT e FROM Estancia e WHERE e.vehiculo.tipo = 'RESIDENTE'")
    List<Estancia> findResidentes();
}
