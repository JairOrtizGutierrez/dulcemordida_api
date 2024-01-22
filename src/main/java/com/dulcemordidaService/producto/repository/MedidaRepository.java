package com.dulcemordidaService.producto.repository;

import com.dulcemordidaService.producto.entity.Medida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedidaRepository extends JpaRepository<Medida, Integer> {
    List<Medida> findAllByOrderByIdDesc();

    List<Medida> findByNombreContains(String nombre);

    Medida findById(@Param("medidaId") int medidaId);

    @Query(value = "select M.*\n" +
            "from medida M\n" +
            "inner join producto P on P.medidaId = M.id\n" +
            "where P.id = :productoId", nativeQuery = true)
    Medida findByProductoId(@Param("productoId") int productoId);
}