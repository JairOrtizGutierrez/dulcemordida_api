package com.dulcemordidaService.venta.repository;

import com.dulcemordidaService.venta.entity.VentaTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VentaTipoRepository extends JpaRepository<VentaTipo, Integer> {
    List<VentaTipo> findAllByOrderByIdDesc();

    List<VentaTipo> findByNombreContains(String nombre);

    VentaTipo findById(@Param("id") int id);
}