package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.DetalleArticuloManufacturado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleArticuloManufacturadoRepository extends BaseRepository <DetalleArticuloManufacturado,Long> {
}
