package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.DetallePedido;
import com.utn.sprint3.entidades.Domicilio;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService{
    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository, DomicilioRepository domicilioRepository) {
        super(baseRepository);
        this.domicilioRepository = domicilioRepository;
    }

    @Override
    public List<Domicilio> searchByLocalidad(String filtrolocalidad) throws Exception {
        try{
            List<Domicilio> domicilios = domicilioRepository.searchByLocalidad(filtrolocalidad);
            return domicilios;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Domicilio> searchByLocalidad(String filtrolocalidad, Pageable pageable) throws Exception {
        try{
            Page<Domicilio> domicilios = domicilioRepository.searchByLocalidad(filtrolocalidad, pageable);
            return domicilios;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Domicilio> searchByCodigoPostal(int filtrocodigoPostal) throws Exception {
        try{
            List<Domicilio> domicilios = domicilioRepository.searchByCodigoPostal(filtrocodigoPostal);
            return domicilios;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Domicilio> searchByCodigoPostal(int filtrocodigoPostal, Pageable pageable) throws Exception {
        try{
            Page<Domicilio> domicilios = domicilioRepository.searchByCodigoPostal(filtrocodigoPostal, pageable);
            return domicilios;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
