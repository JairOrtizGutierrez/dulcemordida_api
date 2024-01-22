package com.dulcemordidaService.gasto.repository;

import com.dulcemordidaService.gasto.entity.GastoTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GastoTipoRepository extends JpaRepository<GastoTipo, Integer> {
    List<GastoTipo> findAllByOrderByIdDesc();

    List<GastoTipo> findByNombreContains(String nombre);

    GastoTipo findById(@Param("id") int id);
}