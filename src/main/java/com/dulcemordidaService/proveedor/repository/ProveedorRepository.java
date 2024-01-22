package com.dulcemordidaService.proveedor.repository;

import com.dulcemordidaService.proveedor.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    List<Proveedor> findByNombreContains(String nombre);

    Proveedor findById(@Param("id") int id);
}