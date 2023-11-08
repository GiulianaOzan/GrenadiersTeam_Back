package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService extends BaseService<Cliente, Long>{
    List<Cliente> search(String DatoCliente) throws Exception;

    Page<Cliente> search(String DatoCliente, Pageable pageable) throws Exception;
}
