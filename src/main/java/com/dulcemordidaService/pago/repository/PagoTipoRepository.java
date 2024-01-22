package com.dulcemordidaService.pago.repository;

import com.dulcemordidaService.pago.entity.PagoTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PagoTipoRepository extends JpaRepository<PagoTipo, Integer> {
    List<PagoTipo> findAllByOrderByIdDesc();

    List<PagoTipo> findByNombreContains(String nombre);

    PagoTipo findById(@Param("id") int id);
}