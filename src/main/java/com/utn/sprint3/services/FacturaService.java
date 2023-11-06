package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.entidades.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface FacturaService extends BaseService<Factura, Long>{

    List<Factura> search(Date fechafiltro) throws Exception;

    Page<Factura> search(Date fechafiltro, Pageable pageable) throws Exception;
}
