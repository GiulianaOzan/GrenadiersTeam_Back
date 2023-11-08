package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.entidades.RubroArticulo;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.RubroArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RubroArticuloServiceImpl extends BaseServiceImpl<RubroArticulo, Long> implements RubroArticuloService{
    @Autowired
    private RubroArticuloRepository rubroArticuloRepository;

    public RubroArticuloServiceImpl(BaseRepository<RubroArticulo, Long> baseRepository, RubroArticuloRepository rubroArticuloRepository) {
        super(baseRepository);
        this.rubroArticuloRepository = rubroArticuloRepository;
    }

    @Override
    public List<RubroArticulo> search(String Denominacion) throws Exception {
        try {
            return rubroArticuloRepository.search(Denominacion);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<RubroArticulo> search(String Denominacion, Pageable pageable) throws Exception {
        try {
            return rubroArticuloRepository.search(Denominacion, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
