package com.utn.sprint3.services;

import com.utn.sprint3.entidades.DetalleArticuloManufacturado;
import com.utn.sprint3.entidades.DetalleFactura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetalleFacturaService extends BaseService<DetalleFactura, Long>{
    List<DetalleFactura> search(Integer numero) throws Exception;

    Page<DetalleFactura> search(Integer numero, Pageable pageable) throws Exception;
}
