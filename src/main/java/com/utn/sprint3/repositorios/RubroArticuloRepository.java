package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.RubroArticulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroArticuloRepository extends BaseRepository <RubroArticulo,Long> {

List<RubroArticulo> findByDenominacion(String denominacion);
Page<RubroArticulo> findByDenominacion(String denominacion, Pageable pageable);

    @Query(value = "SELECT ra FROM RubroArticulo ra WHERE ra.denominacion LIKE %:Denominacion%")
    List<RubroArticulo> search(String Denominacion);

@Query(value = "SELECT ra FROM RubroArticulo ra WHERE ra.denominacion LIKE %:Denominacion%")
    Page<RubroArticulo> search(String Denominacion, Pageable pageable);


//Query nativo
@Query(
        value = "SELECT * FROM RubroArticulo WHERE rubroarticulo.denominacion LIKE %:Denominacion%",
        nativeQuery = true
)
    List<RubroArticulo> searchNativo(String Denominacion);

@Query(
        value = "SELECT * FROM RubroArticulo WHERE rubroarticulo.denominacion LIKE %:Denominacion%",
        nativeQuery = true
)
    Page<RubroArticulo> searchNativo(String Denominacion, Pageable pageable);

}
