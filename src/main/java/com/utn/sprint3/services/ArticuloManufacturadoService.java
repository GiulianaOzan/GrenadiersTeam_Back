package com.utn.sprint3.services;


import com.utn.sprint3.dtos.DTOInsumoRubro;
import com.utn.sprint3.dtos.DTOManufacturadoRubro;
import com.utn.sprint3.dtos.DtoArticuloMasVendido;
import com.utn.sprint3.entidades.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, Long>{
    List<ArticuloManufacturado> search(String filtro) throws Exception;

    Page<ArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception;

    List<DtoArticuloMasVendido> filtradoPorProductoVendidoPorFecha(String fecha1, String fecha2) throws Exception;

    List<DTOManufacturadoRubro> obtenerManufacturadosConRubroYEstado() throws Exception;

}
