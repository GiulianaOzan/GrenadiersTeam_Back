package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.UnidadMedida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadMedidaRepository extends BaseRepository <UnidadMedida,Long> {

    List<UnidadMedida> findByDenominacionAndAbreviatura(String denominacion, String abreviatura);
    Page<UnidadMedida> findByDenominacionAndAbreviatura(String denominacion, String abreviatura, Pageable pageable);

    //anotacion jpql parmetros indexados
    @Query(value = "SELECT um FROM UnidadMedida um WHERE um.denominacion LIKE %:DatosUnidadMedida% OR um.abreviatura LIKE %:DatosUnidadMedida% ")
    List<UnidadMedida> search(@Param("DatosUnidadMedida")String DatosUnidadMedida);

    @Query(value = "SELECT um FROM UnidadMedida um WHERE um.denominacion LIKE %:DatosUnidadMedida% OR um.abreviatura LIKE %:DatosUnidadMedida% ")
    Page<UnidadMedida> search(@Param("DatosUnidadMedida")String DatosUnidadMedida, Pageable pageable);


//    //Query nativo
//    @Query(
//            value = "SELECT * FROM Cliente WHERE cliente.nombre LIKE %:DatoCliente% OR cliente.apellido LIKE %:DatoCliente%",
//            nativeQuery = true
//    )
//    List<Cliente> searchNativo(String DatoCliente);
//
//    @Query(
//            value = "SELECT * FROM Cliente WHERE cliente.nombre LIKE %:DatoCliente% OR cliente.apellido LIKE %:DatoCliente% ",
//            nativeQuery = true
//    )
//    Page<Cliente> searchNativo(String DatoCliente, Pageable pageable);
}
