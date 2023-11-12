package com.utn.sprint3.dtos;

import lombok.*;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class DtoArticuloMasVendido {

    private Long id;
    private String denominacionArticulo;
    private BigDecimal cantidadVendida;

}


