package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository) {

        super(baseRepository);
        this.pedidoRepository= pedidoRepository;
    }
}
