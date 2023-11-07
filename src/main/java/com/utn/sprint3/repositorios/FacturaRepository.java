package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.enums.FormaPago;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository <Factura,Long> {
    List<Factura> findByFechaFacturacion(Date fechaFacturacion);
    Page<Factura> findByFechaFacturacion(Date fechaFacturacion, Pageable pageable);
    List<Factura> findByFormaPago(FormaPago formaPago);
    Page<Factura> findByFormaPago(FormaPago formaPago, Pageable pageable);
    @Query("SELECT f FROM Factura f WHERE f.fechaFacturacion = :fechafiltro")
    List<Factura> search(@Param("fechafiltro") Date fechafiltro);

    @Query("SELECT f FROM Factura f WHERE f.fechaFacturacion = :fechafiltro")
    Page<Factura> search(@Param("fechafiltro") Date fechafiltro, Pageable pageable);

    // Consulta nativa
    @Query(
            value = "SELECT * FROM Factura WHERE factura.fechaFacturacion = :fechafiltro",
            nativeQuery = true
    )
    List<Factura> searchNativo(@Param("fechafiltro") Date fechafiltro);

    @Query(
            value = "SELECT * FROM Factura WHERE factura.fechaFacturacion = :fechafiltro",
            nativeQuery = true
    )
    Page<Factura> searchNativo(@Param("fechafiltro") Date fechafiltro, Pageable pageable);

    @Query("SELECT f FROM Factura f WHERE f.formaPago = :formaPago")
    List<Factura> searchByFormaPago(@Param("formaPago") FormaPago formaPago);

    @Query("SELECT f FROM Factura f WHERE f.formaPago = :formaPago")
    Page<Factura> searchByFormaPago(@Param("formaPago") FormaPago formaPago, Pageable pageable);


}
