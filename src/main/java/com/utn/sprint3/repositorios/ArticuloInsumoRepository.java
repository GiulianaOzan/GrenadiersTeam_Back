package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.ArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository <ArticuloInsumo,Long> {
    List<ArticuloInsumo> findByDenominacion(String denominacion);
    Page<ArticuloInsumo> findByDenominacion(String denominacion, Pageable pageable);

    //anotacion jpql parmetros indexados
    @Query(value = "SELECT a FROM ArticuloInsumo a WHERE a.denominacion LIKE %:filtro%")
    List<ArticuloInsumo> search(String filtro);

    @Query(value = "SELECT a FROM ArticuloInsumo a WHERE a.denominacion LIKE %:filtro%")
    Page<ArticuloInsumo> search(String filtro, Pageable pageable);

    //Query nativo
    @Query(
            value = "SELECT * FROM ArticuloInsumo WHERE a.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<ArticuloInsumo> searchNativo(String filtro);

    @Query(
            value = "SELECT * FROM ArticuloInsumo WHERE a.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    Page<ArticuloInsumo> searchNativo(String filtro,Pageable pageable);
}
