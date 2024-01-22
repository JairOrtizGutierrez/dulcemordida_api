package com.dulcemordidaService.gasto.repository;

import com.dulcemordidaService.gasto.entity.Gasto;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface GastoRepository extends JpaRepository<Gasto, Integer> {
    List<Gasto> findAllByOrderByIdDesc();

    Gasto findById(@Param("id") int id);

    List<Gasto> findByFechaGastoBetweenOrderByIdDesc(@Param("fechaInicial") LocalDate fechaInicial, @Param("fechaFinal") LocalDate fechaFinal);

    @Query(value = "call getDailyExpenses()", nativeQuery = true)
    Tuple getDailyExpenses();

    @Query(value = "call getTotalWeeklyExpenses()", nativeQuery = true)
    List<Tuple> getTotalWeeklyExpenses();

    @Query(value = "call getWeeklyExpenses()", nativeQuery = true)
    Tuple getWeeklyExpenses();

    @Query(value = "call getTotalMonthlyExpenses()", nativeQuery = true)
    Tuple getTotalMonthlyExpenses();

    @Query(value = "call getTotalYearlyExpenses()", nativeQuery = true)
    List<Tuple> getTotalYearlyExpenses();

    @Query(value = "call getYearlyExpenses()", nativeQuery = true)
    Tuple getYearlyExpenses();
}