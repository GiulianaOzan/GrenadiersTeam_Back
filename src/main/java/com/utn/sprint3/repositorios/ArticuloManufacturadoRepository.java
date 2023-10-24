package com.utn.sprint3.repositorios;


import com.utn.sprint3.entidades.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository <ArticuloManufacturado,Long> {
    List<ArticuloManufacturado> findByIdAndDenominacionAndDescripcion(Long id, String denominacion, String descripcion);
    Page<ArticuloManufacturado> findByIdAndDenominacionAndDescripcion(Long id, String denominacion, String descripcion, Pageable pageable);


    //anotacion jpql parmetros indexados
    @Query(value = "SELECT m FROM ArticuloManufacturado m WHERE m.id LIKE%:filtro% OR m.denominacion LIKE %:filtro% OR m.descripcion LIKE%:filtro%")
    List<ArticuloManufacturado> search(String filtro);

    @Query(value = "SELECT m FROM ArticuloManufacturado m WHERE m.id LIKE%:filtro% OR m.denominacion LIKE %:filtro% OR m.descripcion LIKE%:filtro%")
    Page<ArticuloManufacturado> search(String filtro, Pageable pageable);


    //Query nativo
    @Query(
            value = "SELECT * FROM ArticuloManufacturado WHERE articulomanufacturado.id LIKE%:filtro% OR articulomanufacturado.denominacion LIKE %:filtro% OR articulomanufacturado.descripcion LIKE %:filtro% ",
            nativeQuery = true
    )
    List<ArticuloManufacturado> searchNativo(String filtro);

    @Query(
            value = "SELECT * FROM ArticuloManufacturado WHERE articulomanufacturado.id LIKE%:filtro% OR articulomanufacturado.denominacion LIKE %:filtro% OR articulomanufacturado.descripcion LIKE %:filtro% ",
            nativeQuery = true
    )
    Page<ArticuloManufacturado> searchNativo(String filtro,Pageable pageable);



}
