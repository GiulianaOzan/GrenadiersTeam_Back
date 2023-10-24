package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.RubroArticulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroArticuloRepository extends BaseRepository <RubroArticulo,Long> {
}
