package com.dulcemordidaService.pago.repository;

import com.dulcemordidaService.pago.entity.Pago;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
    List<Pago> findAllByOrderByIdDesc();

    Pago findById(@Param("id") int id);

    List<Pago> findByFechaPagoBetweenOrderByIdDesc(@Param("fechaInicial") LocalDate fechaInicial, @Param("fechaFinal") LocalDate fechaFinal);

    @Query(value = "call getDailyPayments()", nativeQuery = true)
    Tuple getDailyPayments();

    @Query(value = "call getTotalWeeklyPayments()", nativeQuery = true)
    List<Tuple> getTotalWeeklyPayments();

    @Query(value = "call getWeeklyPayments()", nativeQuery = true)
    Tuple getWeeklyPayments();

    @Query(value = "call getTotalMonthlyPayments()", nativeQuery = true)
    Tuple getTotalMonthlyPayments();

    @Query(value = "call getTotalYearlyPayments()", nativeQuery = true)
    List<Tuple> getTotalYearlyPayments();

    @Query(value = "call getYearlyPayments()", nativeQuery = true)
    Tuple getYearlyPayments();
}