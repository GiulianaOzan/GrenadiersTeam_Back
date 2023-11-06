package com.utn.sprint3.services;

import com.utn.sprint3.entidades.DetalleArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetalleArticuloManufacturadoService extends BaseService<DetalleArticuloManufacturado, Long>{
    List<DetalleArticuloManufacturado> search(Integer numero) throws Exception;

    Page<DetalleArticuloManufacturado> search(Integer numero, Pageable pageable) throws Exception;
}
