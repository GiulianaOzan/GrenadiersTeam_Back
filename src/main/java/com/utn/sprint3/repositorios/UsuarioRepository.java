package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends BaseRepository <Usuario,Long> {
}
