package com.utn.sprint3.services;

import com.utn.sprint3.entidades.DetalleArticuloManufacturado;
import com.utn.sprint3.entidades.DetalleFactura;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaServiceImpl extends BaseServiceImpl<DetalleFactura, Long> implements DetalleFacturaService{
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    public DetalleFacturaServiceImpl(BaseRepository<DetalleFactura, Long> baseRepository, DetalleFacturaRepository detalleFacturaRepository) {
        super(baseRepository);
        this.detalleFacturaRepository = detalleFacturaRepository;
    }

    @Override
    public List<DetalleFactura> search(Integer numero) throws Exception {
        try{
            return detalleFacturaRepository.search(numero);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<DetalleFactura> search(Integer numero, Pageable pageable) throws Exception {
        try{
            return detalleFacturaRepository.search(numero, pageable);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
