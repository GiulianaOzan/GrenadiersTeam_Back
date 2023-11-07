package com.utn.sprint3.dtos;


import com.utn.sprint3.enums.FormaPago;
import com.utn.sprint3.enums.TipoEnvio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOPedido extends DtoBase{
    private Date fechaPedido;
    private double total;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;

}
