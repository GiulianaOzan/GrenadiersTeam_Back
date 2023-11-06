package com.utn.sprint3.services;

import com.utn.sprint3.entidades.DetalleArticuloManufacturado;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.DetalleArticuloManufacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleArticuloManufacturadoServiceImpl extends BaseServiceImpl<DetalleArticuloManufacturado, Long> implements DetalleArticuloManufacturadoService{
    @Autowired
    private DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;

    public DetalleArticuloManufacturadoServiceImpl(BaseRepository <DetalleArticuloManufacturado, Long> baseRepository, DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository) {
        super(baseRepository);
        this.detalleArticuloManufacturadoRepository = detalleArticuloManufacturadoRepository;
    }
    @Override
    public List<DetalleArticuloManufacturado> search(Integer numero) throws Exception {
        try{
            return detalleArticuloManufacturadoRepository.search(numero);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<DetalleArticuloManufacturado> search(Integer numero, Pageable pageable) throws Exception {
        try{
            return detalleArticuloManufacturadoRepository.search(numero, pageable);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
