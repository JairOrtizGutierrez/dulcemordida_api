package com.dulcemordidaService.ajuste.repository;

import com.dulcemordidaService.ajuste.entity.Ajuste;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AjusteRepository extends JpaRepository<Ajuste, Integer> {
    @Query(value = "select id, concat(date_format(fechaStock, '%d '), concat(ucase(left(date_format(fechaStock, '%M '), 1)), substring(date_format(fechaStock, '%M '), 2)), date_format(fechaStock, '%Y')) as fechaStock\n" +
            "from ajuste\n" +
            "where fechaStock\n" +
            "between :fechaInicial and :fechaFinal\n"+
            "order by fechaStock desc", nativeQuery = true)
    List<Tuple> findByFechaStockBetween(@Param("fechaInicial") LocalDate fechaInicial, @Param("fechaFinal") LocalDate fechaFinal);

    @Query(value = "select id, concat(date_format(fechaStock, '%d '), concat(ucase(left(date_format(fechaStock, '%M '), 1)), substring(date_format(fechaStock, '%M '), 2)), date_format(fechaStock, '%Y')) as fechaStock\n" +
            "from ajuste\n" +
            "order by fechaStock desc", nativeQuery = true)
    List<Tuple> findAjustes();

    Ajuste findByFechaStock(@Param("fechaStock") LocalDate fechaStock);
}