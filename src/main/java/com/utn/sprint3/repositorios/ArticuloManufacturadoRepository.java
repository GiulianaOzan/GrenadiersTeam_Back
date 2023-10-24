package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.ArticuloManufacturado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository <ArticuloManufacturado,Long> {
}
