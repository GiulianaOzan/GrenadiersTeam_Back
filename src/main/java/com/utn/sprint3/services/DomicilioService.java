package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.DetallePedido;
import com.utn.sprint3.entidades.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DomicilioService extends BaseService<Domicilio, Long>{
    List<Domicilio> searchByLocalidad(String filtrolocalidad) throws Exception;

    Page<Domicilio> searchByLocalidad(String filtrolocalidad, Pageable pageable) throws Exception;

   List<Domicilio> searchByCodigoPostal(int filtrocodigoPostal) throws Exception;

    Page<Domicilio> searchByCodigoPostal(int filtrocodigoPostal, Pageable pageable) throws Exception;
}
