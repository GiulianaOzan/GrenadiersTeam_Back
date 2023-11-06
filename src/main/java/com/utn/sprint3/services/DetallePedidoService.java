package com.utn.sprint3.services;

import com.utn.sprint3.entidades.DetalleFactura;
import com.utn.sprint3.entidades.DetallePedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetallePedidoService extends BaseService<DetallePedido, Long>{
    List<DetallePedido> search(Integer numero) throws Exception;

    Page<DetallePedido> search(Integer numero, Pageable pageable) throws Exception;
}
