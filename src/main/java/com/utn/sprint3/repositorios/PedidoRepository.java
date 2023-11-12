package com.utn.sprint3.repositorios;

import com.utn.sprint3.dtos.DtoPedidoEnvio;
import com.utn.sprint3.dtos.DtoPedidoEstado;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.enums.EstadoPedido;
import com.utn.sprint3.enums.TipoEnvio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {
    List<Pedido> findByFechaPedido(Date fechaPedido);

    Page<Pedido> findByFechaPedido(Date fechaPedido, Pageable pageable);

    List<DtoPedidoEnvio> findByTipoEnvio(TipoEnvio tipoEnvio);
    Page<DtoPedidoEnvio> findByTipoEnvio(TipoEnvio tipoEnvio, Pageable pageable);

    // Corrección: Debes usar findByEstadoPedido
    List<DtoPedidoEstado> findByEstado(EstadoPedido estado);
    Page<DtoPedidoEstado> findByEstado(EstadoPedido estado, Pageable pageable);

    List<DtoPedidoEstado> findBy();




    @Query("SELECT p FROM Pedido p WHERE p.fechaPedido = :fechafiltro")
    List<Pedido> search(@Param("fechafiltro") Date fechafiltro);

    @Query("SELECT p FROM Pedido p WHERE p.fechaPedido = :fechafiltro")
    Page<Pedido> search(@Param("fechafiltro") Date fechafiltro, Pageable pageable);

    // Consulta nativa
    @Query(
            value = "SELECT * FROM Pedido WHERE pedido.fechaPedido = :fechafiltro",
            nativeQuery = true
    )
    List<Pedido> searchNativo(@Param("fechafiltro") Date fechafiltro);

    @Query(
            value = "SELECT * FROM Pedido WHERE pedido.fechaPedido = :fechafiltro",
            nativeQuery = true
    )
    Page<Pedido> searchNativo(@Param("fechafiltro") Date fechafiltro, Pageable pageable);

    // Otro método de búsqueda METODO BUSCAR TIPO ENVIO

    @Query("SELECT p FROM Pedido p WHERE p.tipoEnvio = :tipoEnvio")
    List<DtoPedidoEnvio> searchByTipoEnvio(@Param("tipoEnvio") TipoEnvio tipoEnvio);

    @Query("SELECT p FROM Pedido p WHERE p.tipoEnvio = :tipoEnvio")
    Page<DtoPedidoEnvio> searchByTipoEnvio(@Param("tipoEnvio") TipoEnvio tipoEnvio, Pageable pageable);

    //Consulta nativa

    @Query(
            value = "SELECT * FROM Pedido WHERE pedido.tipoEnvio = :tipoEnvio",
            nativeQuery = true
    )
    List<DtoPedidoEnvio> searchNativo(@Param("tipoEnvio") TipoEnvio tipoEnvio);

    @Query(
            value = "SELECT * FROM Pedido WHERE pedido.tipoEnvio = :tipoEnvio",
            nativeQuery = true
    )
    Page<DtoPedidoEnvio> searchNativo(@Param("tipoEnvio") TipoEnvio tipoEnvio, Pageable pageable);

// Buscar por Estado

    @Query("SELECT p FROM Pedido p WHERE p.estado = :estado")
    List<DtoPedidoEstado> searchByEstadoPedido(@Param("estado") EstadoPedido estado);

    @Query("SELECT p FROM Pedido p WHERE p.estado = :estado")
    Page<DtoPedidoEstado> searchByEstadoPedido(@Param("estado") EstadoPedido estado, Pageable pageable);

    //Consulta nativa
    @Query(
            value = "SELECT * FROM Pedido WHERE pedido.estado = :estado",
            nativeQuery = true
    )
    List<DtoPedidoEstado> searchNativo(@Param("estado") EstadoPedido estado);

    @Query(
            value = "SELECT * FROM Pedido WHERE pedido.estado = :estado",
            nativeQuery = true
    )
    Page<DtoPedidoEstado> searchNativo(@Param("estado") EstadoPedido estado, Pageable pageable);

    @Query(value = "SELECT\n" +
            "    COALESCE(SUM(p.total), 0) AS Ingresos,\n" +
            "    COALESCE(SUM(p.total_Costo), 0) AS Costos,\n" +
            "    COALESCE(SUM(p.total - p.total_Costo), 0) AS Ganancias\n" +
            "FROM\n" +
            "    Pedido p\n" +
            "WHERE\n" +
            "    p.fecha_pedido BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Object[]> calcularTotales(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2);



}
