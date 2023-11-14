package com.utn.sprint3.repositorios;

import com.utn.sprint3.dtos.DTOInsumoRubro;
import com.utn.sprint3.entidades.Articulo_Insumo;
import com.utn.sprint3.entidades.Articulo_Insumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<Articulo_Insumo, Long> {
    List<Articulo_Insumo> findByIdAndDenominacion(Long id, String denominacion);

    Page<Articulo_Insumo> findByIdAndDenominacion(Long id, String denominacion, Pageable pageable);

    // Consulta JPQL con parámetros indexados
    @Query("SELECT ai FROM Articulo_Insumo ai WHERE ai.denominacion LIKE %:filtro% OR ai.id LIKE %:filtro%")
    List<Articulo_Insumo> search(@Param("filtro") String filtro);

    @Query("SELECT ai FROM Articulo_Insumo ai WHERE ai.denominacion LIKE %:filtro% OR ai.id LIKE %:filtro%")
    Page<Articulo_Insumo> search(@Param("filtro") String filtro, Pageable pageable);

    // Consulta nativa
    @Query(
            value = "SELECT * FROM Articulo_Insumo ai WHERE articulo_insumo.denominacion LIKE %:filtro% OR articulo_insumo.id LIKE %:filtro%",
            nativeQuery = true
    )
    List<Articulo_Insumo> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM Articulo_Insumo ai WHERE articulo_insumo.denominacion LIKE %:filtro% OR articulo_insumo.id LIKE %:filtro%",
            nativeQuery = true
    )
    Page<Articulo_Insumo> searchNativo(@Param("filtro") String filtro, Pageable pageable);

    // consulta para DTO
    @Query(
            value = "SELECT ai.id, ai.denominacion AS denominacionArticulo, ra.denominacion AS rubroDenominacion, rg.denominacion AS rubroPadreDenominacion, ra.estadoAB AS rubroEstado " +
                    "FROM Articulo_Insumo ai " +
                    "INNER JOIN RubroArticulo ra ON ai.rubroArticulo.id = ra.id " +
                    "LEFT JOIN RubroArticulo rg ON ra.rubroPadre.id = rg.id ",
            nativeQuery = true
    )
    List<Object[]> obtenerInsumosConRubrosYEstados();




}
