package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.RubroGeneral;
import com.utn.sprint3.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroGeneralRepository extends BaseRepository<RubroGeneral, Long> {

    @Query(value = "SELECT * FROM rubro_entidad WHERE denominacion LIKE %?1%", nativeQuery = true)
    List<RubroGeneral> search(String filtro);

    @Query(value = "SELECT * FROM rubro_entidad WHERE denominacion LIKE %?1%", nativeQuery = true)
    Page<RubroGeneral> searchPaged(String filtro, Pageable pageable);


}
