package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.RubroGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroGeneralRepository extends BaseRepository <RubroGeneral,Long> {
}
