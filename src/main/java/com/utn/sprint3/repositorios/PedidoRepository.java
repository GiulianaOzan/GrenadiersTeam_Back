package com.utn.sprint3.repositorios;

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

    List<Pedido> findByTipoEnvio(TipoEnvio tipoEnvio);
    Page<Pedido> findByTipoEnvio(TipoEnvio tipoEnvio, Pageable pageable);

    // Corrección: Debes usar findByEstadoPedido
    List<Pedido> findByEstado(EstadoPedido estado);
    Page<Pedido> findByEstado(EstadoPedido estado, Pageable pageable);


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
    List<Pedido> searchByTipoEnvio(@Param("tipoEnvio") TipoEnvio tipoEnvio);

    @Query("SELECT p FROM Pedido p WHERE p.tipoEnvio = :tipoEnvio")
    Page<Pedido> searchByTipoEnvio(@Param("tipoEnvio") TipoEnvio tipoEnvio, Pageable pageable);

// Buscar por Estado

    @Query("SELECT p FROM Pedido p WHERE p.estado = :estado")
    List<Pedido> searchByEstadoPedido(@Param("estado") EstadoPedido estado);

    @Query("SELECT p FROM Pedido p WHERE p.estado = :estado")
    Page<Pedido> searchByEstadoPedido(@Param("estado") EstadoPedido estado, Pageable pageable);






    // Consulta nativa
    @Query(
            value = "SELECT * FROM Pedido WHERE pedido.tipoEnvio = :tipoEnvio",
            nativeQuery = true
    )
    List<Pedido> searchNativo1(@Param("tipoEnvio") TipoEnvio tipoEnvio);

    @Query(
            value = "SELECT * FROM Pedido WHERE pedido.tipoEnvio = :tipoEnvio",
            nativeQuery = true
    )
    Page<Pedido> searchNativo1(@Param("tipoEnvio") TipoEnvio tipoEnvio, Pageable pageable);
}
