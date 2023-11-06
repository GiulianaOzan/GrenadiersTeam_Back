package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.DetalleArticuloManufacturado;
import com.utn.sprint3.entidades.DetalleFactura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleFacturaRepository extends BaseRepository <DetalleFactura,Long> {

    List<DetalleFactura> findByCantidad(int cantidad);

    Page<DetalleFactura> findByCantidad(int cantidad, Pageable pageable);

    @Query("SELECT f FROM DetalleArticuloManufacturado f WHERE f.cantidad  = :numero")
    List<DetalleFactura> search(@Param("numero") Integer numero);

    @Query("SELECT f FROM DetalleArticuloManufacturado f WHERE f.cantidad = :numero")
    Page<DetalleFactura> search(@Param("numero") Integer numero, Pageable pageable);

    // Consulta nativa
    @Query(
            value = "SELECT * FROM DetalleFactura WHERE detallefactura.cantidad = :numero",
            nativeQuery = true
    )
    List<DetalleFactura> searchNativo(@Param("numero") Integer numero);

    @Query(
            value = "SELECT * FROM DetalleFactura WHERE detallefactura.cantidad = :numero",
            nativeQuery = true
    )
    Page<DetalleFactura> searchNativo(@Param("numero") Integer numero, Pageable pageable);



}

