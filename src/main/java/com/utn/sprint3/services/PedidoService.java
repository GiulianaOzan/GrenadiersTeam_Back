package com.utn.sprint3.services;

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

    //List<Pedido> search1(TipoEnvio filtro) throws Exception;

    //Page<Pedido> search1(TipoEnvio filtro, Pageable pageable) throws Exception;

    List<Pedido> searchByTipoEnvio(TipoEnvio tipoEnvio) throws Exception;

    Page<Pedido> searchByTipoEnvio(TipoEnvio tipoEnvio, Pageable pageable) throws Exception;

    List<Pedido> searchByEstadoPedido(EstadoPedido estado) throws Exception;

    Page<Pedido> searchByEstadoPedido(EstadoPedido estado, Pageable pageable) throws Exception;
}
