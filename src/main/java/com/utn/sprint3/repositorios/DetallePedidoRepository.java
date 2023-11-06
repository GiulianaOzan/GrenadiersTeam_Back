package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.DetalleFactura;
import com.utn.sprint3.entidades.DetallePedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends BaseRepository <DetallePedido,Long> {
    List<DetallePedido> findByCantidad(int cantidad);

    Page<DetallePedido> findByCantidad(int cantidad, Pageable pageable);

    @Query("SELECT p FROM DetallePedido p WHERE p.cantidad  = :numero")
    List<DetallePedido> search(@Param("numero") Integer numero);

    @Query("SELECT p FROM DetallePedido p WHERE p.cantidad = :numero")
    Page<DetallePedido> search(@Param("numero") Integer numero, Pageable pageable);

    // Consulta nativa
    @Query(
            value = "SELECT * FROM DetallePedido WHERE detallepedido.cantidad = :numero",
            nativeQuery = true
    )
    List<DetallePedido> searchNativo(@Param("numero") Integer numero);

    @Query(
            value = "SELECT * FROM DetallePedido WHERE detallepedido.cantidad = :numero",
            nativeQuery = true
    )
    Page<DetallePedido> searchNativo(@Param("numero") Integer numero, Pageable pageable);



}
