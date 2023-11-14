package com.utn.sprint3.services;

import com.utn.sprint3.dtos.*;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.enums.EstadoPedido;
import com.utn.sprint3.enums.TipoEnvio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long> {
    List<Pedido> search(Date fechafiltro) throws Exception;

    Page<Pedido> search(Date fechafiltro, Pageable pageable) throws Exception;


    List<DtoPedidoEnvio> searchByTipoEnvio(TipoEnvio tipoEnvio) throws Exception;

    Page<DtoPedidoEnvio> searchByTipoEnvio(TipoEnvio tipoEnvio, Pageable pageable) throws Exception;

    List<DtoPedidoEstado> searchByEstadoPedido(EstadoPedido estado) throws Exception;

    Page<DtoPedidoEstado> searchByEstadoPedido(EstadoPedido estado, Pageable pageable) throws Exception;

    List<DtoPedidoEstado> findBy();

    List<DtoMovimientosMonetarios> calcularTotales(String fecha1, String fecha2) throws Exception;
    /*List<DtoPedidoCocina> ObtenerPedidoCocina() throws Exception;
*/




}
