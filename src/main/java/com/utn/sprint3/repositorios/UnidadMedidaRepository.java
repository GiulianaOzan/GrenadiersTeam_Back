package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.UnidadMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadMedidaRepository extends BaseRepository <UnidadMedida,Long> {
}
