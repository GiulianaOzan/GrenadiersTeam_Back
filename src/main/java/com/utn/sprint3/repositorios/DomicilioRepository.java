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
    List<Domicilio> search(@Param("filtrolocalidad")String filtrolocalidad);

    @Query(
            value = "SELECT * FROM Domicilio WHERE domicilio.localidad LIKE %:filtrolocalidad%",
            nativeQuery = true
    )
    Page<Domicilio> search(@Param("filtrolocalidad")String filtrolocalidad, Pageable pageable);

}
