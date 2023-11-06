package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService{
    @Autowired
    private FacturaRepository facturaRepository;

    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository, FacturaRepository facturaRepository) {
        super(baseRepository);
        this.facturaRepository = facturaRepository;
    }

    @Override
    public List<Factura> search(Date fechafiltro) throws Exception {
        try {
            return facturaRepository.search(fechafiltro);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Factura> search(Date fechafiltro, Pageable pageable) throws Exception {
        try {
            return facturaRepository.search(fechafiltro, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
