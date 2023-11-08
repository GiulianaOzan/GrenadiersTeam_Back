package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.enums.EstadoPedido;
import com.utn.sprint3.enums.Rol;
import com.utn.sprint3.enums.TipoEnvio;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;


@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository,UsuarioRepository usuarioRepository) {
        super(baseRepository);
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public List<Usuario> search(String username) throws Exception {
        try{
            //List<Usuario> usuarios = usuarioRepository.findByUsername(filtro);
            List<Usuario> usuarios = usuarioRepository.search(username);
            //List<Usuario> usuarios = usuarioRepository.search(filtro);
            return usuarios;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    public Page<Usuario> search(String username, Pageable pageable) throws Exception {
        try{
            Page<Usuario> usuarios = usuarioRepository.search(username, pageable);
            return usuarios;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Usuario por Rol
    @Override
    public List<Usuario> searchByRol(Rol rol) throws Exception {
        try {
            return usuarioRepository.searchByRol(rol);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Usuario> searchByRol(Rol rol, Pageable pageable) throws Exception {
        try {
            return usuarioRepository.searchByRol(rol, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
