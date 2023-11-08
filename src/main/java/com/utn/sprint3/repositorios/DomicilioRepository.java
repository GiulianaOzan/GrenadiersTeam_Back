package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.Domicilio;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.enums.EstadoPedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {
    List<Domicilio> findByLocalidad(String localidad);
    Page<Domicilio> findByLocalidad(String localidad, Pageable pageable);

    List<Domicilio> findByCodigoPostal(int codigoPostal);
    Page<Domicilio> findByCodigoPostal(int codigoPostal, Pageable pageable);



    //anotacion jpql parmetros indexados
    @Query(value = "SELECT d FROM Domicilio d WHERE d.localidad LIKE %:filtrolocalidad% ")
    List<Domicilio> searchByLocalidad(@Param("filtrolocalidad")String filtrolocalidad);

    @Query(value = "SELECT d FROM Domicilio d WHERE d.localidad LIKE %:filtrolocalidad% ")
    Page<Domicilio> searchByLocalidad(@Param("filtrolocalidad")String filtrolocalidad, Pageable pageable);


    //Query nativo
    @Query(
            value = "SELECT * FROM Domicilio WHERE domicilio.localidad LIKE %:filtrolocalidad%",
            nativeQuery = true
    )
    List<Domicilio> searchNativo(@Param("filtrolocalidad")String filtrolocalidad);

    @Query(
            value = "SELECT * FROM Domicilio WHERE domicilio.localidad LIKE %:filtrolocalidad%",
            nativeQuery = true
    )
    Page<Domicilio> searchNativo(@Param("filtrolocalidad")String filtrolocalidad, Pageable pageable);

    //Busqueda por codigo Postal
    @Query(value = "SELECT d FROM Domicilio d WHERE d.codigoPostal = :filtrocodigoPostal ")
    List<Domicilio> searchByCodigoPostal(@Param("filtrocodigoPostal")int filtrocodigoPostal);

    @Query(value = "SELECT d FROM Domicilio d WHERE d.codigoPostal = :filtrocodigoPostal ")
    Page<Domicilio> searchByCodigoPostal(@Param("filtrocodigoPostal")int filtrocodigoPostal, Pageable pageable);


    //Query nativo
    @Query(
            value = "SELECT * FROM Domicilio WHERE domicilio.codigoPostal = :filtrocodigoPostal",
            nativeQuery = true
    )
    List<Domicilio> searchNativo(@Param("filtrocodigoPostal")int filtrocodigoPostal);

    @Query(
            value = "SELECT * FROM Domicilio WHERE domicilio.codigoPostal = :filtrocodigoPostal",
            nativeQuery = true
    )
    Page<Domicilio> searchNativo(@Param("filtrocodigoPostal")int filtrocodigoPostal, Pageable pageable);

}
