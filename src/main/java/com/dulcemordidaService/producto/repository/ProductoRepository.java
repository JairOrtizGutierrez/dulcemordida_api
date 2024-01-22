package com.dulcemordidaService.producto.repository;

import com.dulcemordidaService.producto.entity.Producto;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findAllByOrderByIdDesc();

    List<Producto> findByNombreContains(String nombre);

    Producto findById(@Param("productoId") int productoId);
}