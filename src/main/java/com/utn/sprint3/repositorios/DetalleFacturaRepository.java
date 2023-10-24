package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaRepository extends BaseRepository <DetalleFactura,Long> {
}
