package com.utn.sprint3.services;

import com.utn.sprint3.dtos.DtoCliente;
import com.utn.sprint3.dtos.DtoRankingClientes;
import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteService extends BaseService<Cliente, Long>{
    List<Cliente> search(String DatoCliente) throws Exception;

    Page<Cliente> search(String DatoCliente, Pageable pageable) throws Exception;

    List<DtoCliente> findBy();
    List<DtoRankingClientes> rankingClientesPorCompras(String fecha1, String fecha2) throws Exception;

}
