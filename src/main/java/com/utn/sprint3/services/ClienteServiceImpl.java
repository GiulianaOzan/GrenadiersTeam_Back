package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.ClienteRepository;
import com.utn.sprint3.repositorios.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long>{
@Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository, ClienteRepository clienteRepository){
        super(baseRepository);
        this.clienteRepository = clienteRepository;
    }
}
