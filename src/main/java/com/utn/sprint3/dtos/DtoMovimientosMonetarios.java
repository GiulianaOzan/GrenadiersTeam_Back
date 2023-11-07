package com.utn.sprint3.dtos;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor


public class DtoMovimientosMonetarios extends DtoBase {

    private BigDecimal ingresos;
    private BigDecimal costos;
    private BigDecimal ganancias;
}
