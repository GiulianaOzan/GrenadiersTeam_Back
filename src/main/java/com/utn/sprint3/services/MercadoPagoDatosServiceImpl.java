package com.utn.sprint3.services;

import com.utn.sprint3.entidades.MercadoPagoDatos;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.MercadoPagoDatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MercadoPagoDatosServiceImpl extends BaseServiceImpl<MercadoPagoDatos, Long>{
    @Autowired
    private MercadoPagoDatosRepository mercadoPagoDatosRepository;

    public MercadoPagoDatosServiceImpl(BaseRepository<MercadoPagoDatos, Long> baseRepository, MercadoPagoDatosRepository mercadoPagoDatosRepository) {
        super(baseRepository);
        this.mercadoPagoDatosRepository = mercadoPagoDatosRepository;
    }
}
