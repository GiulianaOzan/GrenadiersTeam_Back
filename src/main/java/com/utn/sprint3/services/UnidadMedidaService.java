package com.utn.sprint3.services;

import com.utn.sprint3.entidades.UnidadMedida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UnidadMedidaService extends BaseService<UnidadMedida, Long>{
    List<UnidadMedida> search(String DatosUnidadMediad) throws Exception;
    Page<UnidadMedida> search(String DatosUnidadMedida, Pageable pageable) throws Exception;
}
