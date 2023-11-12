package com.utn.sprint3.repositorios;


import com.utn.sprint3.dtos.DtoArticuloMasVendido;
import com.utn.sprint3.entidades.ArticuloManufacturado;
import com.utn.sprint3.entidades.Articulo_Insumo;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@SqlResultSetMapping(
        name = "DtoArticuloMasVendidoMapping",
        classes = @ConstructorResult(
                targetClass = DtoArticuloMasVendido.class,
                columns = {
                        @ColumnResult(name = "denominacion", type = String.class),
                        @ColumnResult(name = "cantidadVendida", type = Long.class)
                }
        )
)
@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long> {
    List<ArticuloManufacturado> findByDenominacionAndDescripcion(String denominacion, String descripcion);

    Page<ArticuloManufacturado> findByDenominacionAndDescripcion(String denominacion, String descripcion, Pageable pageable);

    /*List<DtoArticuloMasVendido> findByDenominacionAndCantidadVendida(String denominacion, int cantidadVendida);*/

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


    @Query(value = "SELECT\n" +
            "    am.id,\n" +
            "    am.denominacion AS denominacionArticulo,\n" +
            "    COALESCE(SUM(df.cantidadVendida), 0) AS cantidadVendida\n" +
            "FROM\n" +
            "    Articulo_Manufacturado am\n" +
            "LEFT JOIN\n" +
            "    (\n" +
            "        SELECT\n" +
            "            df.id_articulo_manufacturado,\n" +
            "            SUM(df.cantidad) AS cantidadVendida\n" +
            "        FROM\n" +
            "            Detalle_Factura df\n" +
            "        JOIN\n" +
            "            Factura f ON df.id_factura = f.id\n" +
            "        WHERE\n" +
            "            f.fecha_facturacion BETWEEN ?1 AND ?2\n" +
            "        GROUP BY\n" +
            "            df.id_articulo_manufacturado\n" +
            "    ) df ON am.id = df.id_articulo_manufacturado\n" +
            "GROUP BY\n" +
            "    am.id, am.denominacion\n" +
            "ORDER BY\n" +
            "    cantidadVendida DESC;", nativeQuery = true)
    List<Object[]> filtradoPorProductoVendidoPorFecha(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2);


}
