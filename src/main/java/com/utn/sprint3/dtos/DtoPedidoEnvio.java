package com.utn.sprint3.dtos;

import com.utn.sprint3.entidades.Domicilio;
import com.utn.sprint3.enums.EstadoPedido;
import com.utn.sprint3.enums.FormaPago;
import com.utn.sprint3.enums.TipoEnvio;
import jakarta.persistence.Column;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;
import java.util.List;

public interface DtoPedidoEnvio {

    List<DtoPedidoEnvio.DtoDetallePedido> getDetallePedidos();

    interface DtoDetallePedido {
        int getCantidad();
        DtoPedidoEnvio.ArticuloManufacturadoDTO getArticuloManufacturado();
    }

    interface ArticuloManufacturadoDTO {
        String getDenominacion(); // ajusta según tu modelo
    }

    DtoPedidoEnvio.DTODomicilio getdomicilio();

    interface DTODomicilio {

        String getcalle();

       int getnumero();

        String getlocalidad();

        int getnumeroDpto();

       int getpisoDpto();
    }
    long getid();
    Date getfechaPedido();

    Date gethoraEstimadaFinalizacion();

    double gettotal();

    EstadoPedido getestado();

    TipoEnvio gettipoEnvio();

    FormaPago getformaPago();

}
