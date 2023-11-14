package com.utn.sprint3.services;

import com.utn.sprint3.dtos.DTOInsumoRubro;
import com.utn.sprint3.entidades.Articulo_Insumo;
import com.utn.sprint3.entidades.Articulo_Insumo;
import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.enums.EstadoAB;
import com.utn.sprint3.repositorios.ArticuloInsumoRepository;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<Articulo_Insumo, Long> implements ArticuloInsumoService {
    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    public ArticuloInsumoServiceImpl(ArticuloInsumoRepository articuloInsumoRepository) {
        super(articuloInsumoRepository);
    }

    @Override
    public List<Articulo_Insumo> search(String filtro) throws Exception {
        try {
            return articuloInsumoRepository.search(filtro);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Articulo_Insumo> search(String filtro, Pageable pageable) throws Exception {
        try {
            return articuloInsumoRepository.search(filtro, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<DTOInsumoRubro> obtenerInsumosConRubrosYEstados() throws Exception {
        try {
            List<Object[]> resultados = articuloInsumoRepository.obtenerInsumosConRubrosYEstados();
            List<DTOInsumoRubro> dtos = new ArrayList<>();

            for (Object[] resultado : resultados) {
                DTOInsumoRubro dto = new DTOInsumoRubro();
                dto.setInsumoDenominacion((String) resultado[1]);
                dto.setRubroDenominacion((String) resultado[2]);
                dto.setRubroPadreDenominacion((String) resultado[3]);
                dto.setRubroEstado((EstadoAB) resultado[4]);
                dtos.add(dto);
            }

            return dtos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
