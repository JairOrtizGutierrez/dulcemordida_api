package com.dulcemordidaService.producto.repository;

import com.dulcemordidaService.producto.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
    List<Marca> findAllByOrderByIdDesc();

    List<Marca> findByNombreContains(String nombre);

    Marca findById(@Param("id") int id);
}