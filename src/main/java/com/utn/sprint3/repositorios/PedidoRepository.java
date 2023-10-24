package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends BaseRepository <Pedido,Long> {
}
