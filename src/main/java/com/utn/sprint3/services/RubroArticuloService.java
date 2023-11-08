package com.utn.sprint3.services;

import com.utn.sprint3.entidades.RubroArticulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RubroArticuloService extends BaseService<RubroArticulo, Long>{

    List<RubroArticulo> search(String Denominacion) throws Exception;

    Page<RubroArticulo> search(String Denominacion, Pageable pageable) throws Exception;


}
