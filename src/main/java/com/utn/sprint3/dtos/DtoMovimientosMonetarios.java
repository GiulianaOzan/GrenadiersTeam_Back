package com.utn.sprint3.dtos;


import lombok.*;

import java.math.BigDecimal;


@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)

public class DtoMovimientosMonetarios {

    private BigDecimal ingresos;
    private BigDecimal costos;
    private BigDecimal ganancias;
}
