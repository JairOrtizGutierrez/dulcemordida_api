package com.dulcemordidaService.gasto.service;

import com.dulcemordidaService.gasto.entity.Gasto;
import com.dulcemordidaService.gasto.entity.GastoFormWrapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GastoService {
    Gasto createGasto(Gasto gasto);

    List<Gasto> getAllGastos();

    Gasto updateGasto(Gasto gasto);

    void deleteGasto(int id);

    Gasto getGastoById(int id);

    List<Gasto> getGastoByRangoFechas(LocalDate fechaInicial, LocalDate fechaFinal);

    ObjectNode getDailyExpenses();

    List<ObjectNode> getTotalWeeklyExpenses();

    ObjectNode getWeeklyExpenses();

    ObjectNode getTotalMonthlyExpenses();

    List<ObjectNode> getTotalYearlyExpenses();

    ObjectNode getYearlyExpenses();

    Optional<Gasto> createGasto(GastoFormWrapper gastoFormWrapper);

    Optional<Gasto> updateGasto(GastoFormWrapper gastoFormWrapper);
}