package com.utn.sprint3.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DtoMovimientosMonetarios {

    private BigDecimal ingresos;
    private BigDecimal costos;
    private BigDecimal ganancias;
}
