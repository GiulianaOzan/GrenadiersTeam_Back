package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.ArticuloManufacturado;
import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.DetalleArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleArticuloManufacturadoRepository extends BaseRepository <DetalleArticuloManufacturado,Long> {
    List<DetalleArticuloManufacturado> findByCantidad(int cantidad);

    Page<DetalleArticuloManufacturado> findByCantidad(int cantidad, Pageable pageable);

    @Query("SELECT dam FROM DetalleArticuloManufacturado dam WHERE dam.cantidad  = :numero")
    List<DetalleArticuloManufacturado> search(@Param("numero") Integer numero);

    @Query("SELECT dam FROM DetalleArticuloManufacturado dam WHERE dam.cantidad = :numero")
    Page<DetalleArticuloManufacturado> search(@Param("numero") Integer numero, Pageable pageable);

    // Consulta nativa
    @Query(
            value = "SELECT * FROM DetalleArticuloManufacturado WHERE detallearticulomanufacturado.cantidad = :numero",
            nativeQuery = true
    )
    List<DetalleArticuloManufacturado> searchNativo(@Param("numero") Integer numero);

    @Query(
            value = "SELECT * FROM DetalleArticuloManufacturado WHERE detallearticulomanufacturado.cantidad = :numero",
            nativeQuery = true
    )
    Page<DetalleArticuloManufacturado> searchNativo(@Param("numero") Integer numero, Pageable pageable);



}
