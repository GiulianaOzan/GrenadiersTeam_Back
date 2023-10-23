package com.utn.sprint3.services;

import com.utn.sprint3.entidades.RubroGeneral;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.RubroArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroGeneralServiceImpl extends BaseServiceImpl<RubroGeneral, Long>{
    @Autowired
    private RubroArticuloRepository rubroArticuloRepository;

    public RubroGeneralServiceImpl(BaseRepository<RubroGeneral, Long> baseRepository, RubroArticuloRepository rubroArticuloRepository) {
        super(baseRepository);
        this.rubroArticuloRepository = rubroArticuloRepository;
    }
}
