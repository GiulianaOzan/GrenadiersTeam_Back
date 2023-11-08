package com.utn.sprint3.services;

import com.utn.sprint3.entidades.RubroGeneral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RubroGeneralService extends BaseService<RubroGeneral, Long>{

    List<RubroGeneral> search(String filtro) throws Exception;

    Page<RubroGeneral> searchPaged(String filtro, Pageable pageable) throws Exception;

}
