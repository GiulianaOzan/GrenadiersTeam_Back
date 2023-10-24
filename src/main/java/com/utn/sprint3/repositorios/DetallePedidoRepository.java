package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends BaseRepository <DetallePedido,Long> {
}
