package com.utn.sprint3.repositorios;

import com.utn.sprint3.dtos.DtoCliente;
import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository <Cliente,Long> {
    List<Cliente> findByNombreAndApellido(String nombre, String apellido);
    Page<Cliente> findByNombreAndApellido(String nombre, String apellido, Pageable pageable);

    List<DtoCliente> findBy();



    //anotacion jpql parmetros indexados
    @Query(value = "SELECT c FROM Cliente c WHERE c.nombre LIKE %:DatoCliente% OR c.apellido LIKE %:DatoCliente% ")
    List<Cliente> search(String DatoCliente);

    @Query(value = "SELECT c FROM Cliente c WHERE c.nombre LIKE %:DatoCliente% OR c.apellido LIKE %:DatoCliente% ")
    Page<Cliente> search(String DatoCliente, Pageable pageable);


    //Query nativo
    @Query(
            value = "SELECT * FROM Cliente WHERE cliente.nombre LIKE %:DatoCliente% OR cliente.apellido LIKE %:DatoCliente%",
            nativeQuery = true
    )
    List<Cliente> searchNativo(String DatoCliente);

    @Query(
            value = "SELECT * FROM Cliente WHERE cliente.nombre LIKE %:DatoCliente% OR cliente.apellido LIKE %:DatoCliente% ",
            nativeQuery = true
    )
    Page<Cliente> searchNativo(String DatoCliente, Pageable pageable);

    @Query(value = "SELECT\n" +
            "    c.id AS id_Clinete,\n" +
            "    c.nombre AS nombreCliente,\n" +
            "    c.apellido AS apellidoCliente,\n" +
            "    COALESCE(SUM(dp.cantidad), 0) AS cantidadComprada,\n" +
            "    COALESCE(SUM(p.total), 0) AS montoTotalComprado\n" +
            "FROM\n" +
            "    Cliente c\n" +
            "LEFT JOIN\n" +
            "    Pedido p ON c.id = p.id_cliente\n" +
            "LEFT JOIN\n" +
            "    Detalle_Pedido dp ON p.id = dp.id_pedido\n" +
            "WHERE\n" +
            "    p.fecha_pedido BETWEEN ?1 AND ?2\n" +
            "GROUP BY\n" +
            "    c.id, c.nombre\n" +
            "ORDER BY\n" +
            "    cantidadComprada DESC, montoTotalComprado DESC;", nativeQuery = true)
    List<Object[]> rankingClientesPorCompras(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2);

}
