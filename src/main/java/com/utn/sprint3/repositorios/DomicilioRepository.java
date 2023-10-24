package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository  extends BaseRepository <Domicilio,Long> {
}
