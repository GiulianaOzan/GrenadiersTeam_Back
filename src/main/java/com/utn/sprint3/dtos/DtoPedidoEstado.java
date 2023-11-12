package com.utn.sprint3.dtos;

import com.utn.sprint3.entidades.ArticuloManufacturado;
import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.DetallePedido;
import com.utn.sprint3.entidades.Domicilio;
import com.utn.sprint3.enums.EstadoPedido;
import com.utn.sprint3.enums.FormaPago;
import com.utn.sprint3.enums.TipoEnvio;
import jakarta.persistence.*;
import lombok.Builder;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface DtoPedidoEstado {

    long getid();
    Date getfechaPedido();
  
    Date gethoraEstimadaFinalizacion();
    
    double gettotal();

    EstadoPedido getestado();

    TipoEnvio gettipoEnvio();

    FormaPago getformaPago();
    List<DtoDetallePedido> getDetallePedidos();

    interface DtoDetallePedido {
        int getCantidad();
        ArticuloManufacturadoDTO getArticuloManufacturado();
    }

    interface ArticuloManufacturadoDTO {
        String getDenominacion(); // ajusta según tu modelo
    }

}
