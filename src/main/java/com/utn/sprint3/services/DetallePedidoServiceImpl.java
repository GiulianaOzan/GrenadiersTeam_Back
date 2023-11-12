package com.utn.sprint3.services;

import com.utn.sprint3.dtos.DtoArticuloMasVendido;
import com.utn.sprint3.entidades.DetallePedido;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService{
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository, DetallePedidoRepository detallePedidoRepository) {
        super(baseRepository);
        this.detallePedidoRepository = detallePedidoRepository;
    }
    @Override
    public List<DetallePedido> search(Integer numero) throws Exception {
        try{
            return detallePedidoRepository.search(numero);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<DetallePedido> search(Integer numero, Pageable pageable) throws Exception {
        try{
            return detallePedidoRepository.search(numero, pageable);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
