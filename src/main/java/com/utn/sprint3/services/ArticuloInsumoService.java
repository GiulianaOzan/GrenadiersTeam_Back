package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Articulo_Insumo;
import com.utn.sprint3.entidades.Articulo_Insumo;
import com.utn.sprint3.entidades.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticuloInsumoService extends BaseService<Articulo_Insumo, Long>{

    List<Articulo_Insumo> search(String filtro) throws Exception;

    Page<Articulo_Insumo> search(String filtro, Pageable pageable) throws Exception;
}
