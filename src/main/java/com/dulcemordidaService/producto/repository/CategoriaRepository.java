package com.dulcemordidaService.producto.repository;

import com.dulcemordidaService.producto.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    List<Categoria> findAllByOrderByIdDesc();

    List<Categoria> findByNombreContains(String nombre);

    Categoria findById(@Param("categoriaId") int categoriaId);
}
