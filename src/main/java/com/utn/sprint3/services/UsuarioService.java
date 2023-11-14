package com.utn.sprint3.services;

import com.utn.sprint3.dtos.DtoArticuloMasVendido;
import com.utn.sprint3.dtos.DtoEmpleados;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.enums.Rol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UsuarioService extends BaseService<Usuario, Long>{
    List<Usuario> search(String username) throws Exception;

    Page<Usuario> search(String username, Pageable pageable) throws Exception;

    List<Usuario> searchByRol(Rol rol) throws Exception;

    Page<Usuario> searchByRol(Rol rol, Pageable pageable) throws Exception;

    List<DtoEmpleados> obtenerEmpleadosExceptoClientes() throws Exception;
}
