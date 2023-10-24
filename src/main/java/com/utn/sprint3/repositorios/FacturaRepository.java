package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends BaseRepository <Factura,Long> {
}
