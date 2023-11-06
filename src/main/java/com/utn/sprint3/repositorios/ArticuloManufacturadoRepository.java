package com.utn.sprint3.repositorios;


import com.utn.sprint3.entidades.ArticuloManufacturado;
import com.utn.sprint3.entidades.Articulo_Insumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository <ArticuloManufacturado,Long> {
    List<ArticuloManufacturado> findByDenominacionAndDescripcion(String denominacion, String descripcion);
    Page<ArticuloManufacturado> findByDenominacionAndDescripcion(String denominacion, String descripcion, Pageable pageable);


    //anotacion jpql parmetros indexados
    @Query("SELECT am FROM ArticuloManufacturado am WHERE am.denominacion LIKE %:filtro% OR am.descripcion LIKE %:filtro%")
    List<ArticuloManufacturado> search(@Param("filtro") String filtro);

    @Query("SELECT am FROM ArticuloManufacturado am WHERE am.denominacion LIKE %:filtro% OR am.descripcion LIKE %:filtro%")
    Page<ArticuloManufacturado> search(@Param("filtro") String filtro, Pageable pageable);

    // Consulta nativa
    @Query(
            value = "SELECT * FROM ArticuloManufacturado WHERE articuloManufacturado.denominacion LIKE %:filtro% OR articuloManufacturado.descripcion LIKE %:filtro%",
            nativeQuery = true
    )
    List<ArticuloManufacturado> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM ArticuloManufacturado WHERE articuloManufacturado.denominacion LIKE %:filtro% OR articuloManufacturado.descripcion LIKE %:filtro%",
            nativeQuery = true
    )
    Page<ArticuloManufacturado> searchNativo(@Param("filtro") String filtro, Pageable pageable);



}
