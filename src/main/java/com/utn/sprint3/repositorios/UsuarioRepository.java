package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends BaseRepository <Usuario,Long> {
    List<Usuario> findByauth0IdAndUsername(String auth0Id, String username);
        Page<Usuario> findByUsername(String username, Pageable pageable);


    //anotacion jpql parmetros indexados
    @Query(value = "SELECT u FROM Usuario u WHERE u.username LIKE %:filtro% ")
    List<Usuario> search(String filtro);

    @Query(value = "SELECT u FROM Usuario u WHERE u.username LIKE %:filtro% ")
    Page<Usuario> search(String filtro, Pageable pageable);


    //Query nativo
    @Query(
            value = "SELECT * FROM Usuario WHERE usuario.username LIKE %:filtro% ",
            nativeQuery = true
    )
    List<Usuario> searchNativo(String filtro);

    @Query(
            value = "SELECT * FROM Usuario WHERE usuario.username LIKE %:filtro% ",
            nativeQuery = true
    )
    Page<Usuario> searchNativo(String filtro, Pageable pageable);
}