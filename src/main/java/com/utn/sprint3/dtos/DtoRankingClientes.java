package com.utn.sprint3.dtos;

import lombok.*;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class DtoRankingClientes {

    private long id_Clinete;
    private String nombreCliente;
    private String apellidoCliente;
    private BigDecimal cantidadComprada;
    private BigDecimal montoTotalComprado;

}
