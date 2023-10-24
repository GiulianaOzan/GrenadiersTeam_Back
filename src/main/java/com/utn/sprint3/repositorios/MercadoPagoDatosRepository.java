package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.MercadoPagoDatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercadoPagoDatosRepository extends BaseRepository <MercadoPagoDatos,Long> {
}
