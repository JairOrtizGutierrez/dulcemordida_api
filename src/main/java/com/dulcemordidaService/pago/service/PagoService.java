package com.dulcemordidaService.pago.service;

import com.dulcemordidaService.pago.entity.Pago;
import com.dulcemordidaService.pago.entity.PagoFormWrapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PagoService {
    Pago createPago(Pago pago);

    List<Pago> getAllPagos();

    Pago updatePago(Pago pago);

    void deletePago(int id);

    Pago getPagoById(int id);

    List<Pago> getPagoByRangoFechas(LocalDate fechaInicial, LocalDate fechaFinal);

    ObjectNode getDailyPayments();

    List<ObjectNode> getTotalWeeklyPayments();

    ObjectNode getWeeklyPayments();

    ObjectNode getTotalMonthlyPayments();

    List<ObjectNode> getTotalYearlyPayments();

    ObjectNode getYearlyPayments();

    Optional<Pago> createPago(PagoFormWrapper pagoFormWrapper);

    Optional<Pago> updatePago(PagoFormWrapper pagoFormWrapper);
}