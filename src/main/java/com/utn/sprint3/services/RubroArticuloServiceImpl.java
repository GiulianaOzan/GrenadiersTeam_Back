package com.utn.sprint3.services;

import com.utn.sprint3.entidades.RubroArticulo;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.RubroArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroArticuloServiceImpl extends BaseServiceImpl<RubroArticulo, Long>{
    @Autowired
    private RubroArticuloRepository rubroArticuloRepository;

    public RubroArticuloServiceImpl(BaseRepository<RubroArticulo, Long> baseRepository, RubroArticuloRepository rubroArticuloRepository) {
        super(baseRepository);
        this.rubroArticuloRepository = rubroArticuloRepository;
    }
}
