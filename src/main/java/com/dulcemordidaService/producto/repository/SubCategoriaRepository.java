package com.dulcemordidaService.producto.repository;

import com.dulcemordidaService.producto.entity.SubCategoria;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Integer> {
    List<SubCategoria> findAllByOrderByIdDesc();

    List<SubCategoria> findByNombreContains(String nombre);

    SubCategoria findById(@Param("subCategoriaId") int subCategoriaId);

    @Query(value = "select * from subCategoria where categoriaId = :categoriaId", nativeQuery = true)
    List<SubCategoria> findSubcategoriasByCategoriaId(@Param("categoriaId") int categoriaId);
}