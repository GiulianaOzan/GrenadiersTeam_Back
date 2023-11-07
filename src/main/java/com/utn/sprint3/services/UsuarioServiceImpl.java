package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


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
            Page<Usuario> usuarios = usuarioRepository.searchNativo(username, pageable);
            return usuarios;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
