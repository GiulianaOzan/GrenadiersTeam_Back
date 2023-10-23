package com.utn.sprint3.services;

import com.utn.sprint3.entidades.DetalleFactura;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleFacturaServiceImpl extends BaseServiceImpl<DetalleFactura, Long>{
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    public DetalleFacturaServiceImpl(BaseRepository<DetalleFactura, Long> baseRepository, DetalleFacturaRepository detalleFacturaRepository) {
        super(baseRepository);
        this.detalleFacturaRepository = detalleFacturaRepository;
    }
}
