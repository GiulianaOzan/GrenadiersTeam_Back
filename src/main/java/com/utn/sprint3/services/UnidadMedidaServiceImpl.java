package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.UnidadMedida;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida, Long> implements UnidadMedidaService{
    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public UnidadMedidaServiceImpl(BaseRepository<UnidadMedida, Long> baseRepository, UnidadMedidaRepository unidadMedidaRepository) {
        super(baseRepository);
        this.unidadMedidaRepository = unidadMedidaRepository;
    }

    @Override
    public List<UnidadMedida> search(String DatosUnidadMedida) throws Exception {
        try{
            List<UnidadMedida> unidadMedida = unidadMedidaRepository.search(DatosUnidadMedida);
            return unidadMedida;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<UnidadMedida> search(String DatosUnidadMedida, Pageable pageable) throws Exception {
        try{
            Page<UnidadMedida> unidadMedida = unidadMedidaRepository.search(DatosUnidadMedida, pageable);
            return unidadMedida;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
