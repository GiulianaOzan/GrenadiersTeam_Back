package com.utn.sprint3.services;

import com.utn.sprint3.entidades.DetalleArticuloManufacturado;
import com.utn.sprint3.repositorios.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleArticuloManufacturadoServiceImpl extends BaseServiceImpl<DetalleArticuloManufacturado, Long>{
    @Autowired
    private DetalleArticuloManufacturado detalleArticuloManufacturado;

    public DetalleArticuloManufacturadoServiceImpl(BaseRepository<DetalleArticuloManufacturado, Long> baseRepository, DetalleArticuloManufacturado detalleArticuloManufacturado) {
        super(baseRepository);
        this.detalleArticuloManufacturado = detalleArticuloManufacturado;
    }
}
