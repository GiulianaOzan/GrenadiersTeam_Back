package com.utn.sprint3.services;

import com.utn.sprint3.dtos.DTOInsumoRubro;
import com.utn.sprint3.dtos.DTOManufacturadoRubro;
import com.utn.sprint3.dtos.DtoArticuloMasVendido;
import com.utn.sprint3.entidades.Articulo_Insumo;
import com.utn.sprint3.entidades.ArticuloManufacturado;
import com.utn.sprint3.enums.EstadoAB;
import com.utn.sprint3.repositorios.ArticuloManufacturadoRepository;
import com.utn.sprint3.repositorios.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements ArticuloManufacturadoService {
    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(baseRepository);
        this.articuloManufacturadoRepository = articuloManufacturadoRepository;
    }

    @Override
    public List<ArticuloManufacturado> search(String filtro) throws Exception {
        try {
            return articuloManufacturadoRepository.search(filtro);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception {
        try {
            return articuloManufacturadoRepository.search(filtro, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }



    @Override
    @Transactional
    public List<DtoArticuloMasVendido> filtradoPorProductoVendidoPorFecha(String fecha1, String fecha2) throws Exception {
        try {
            List<Object[]> entities = articuloManufacturadoRepository.filtradoPorProductoVendidoPorFecha(fecha1, fecha2);
            List<DtoArticuloMasVendido> dtos = new ArrayList<>();

            for (Object[] entity : entities) {
                DtoArticuloMasVendido dto = new DtoArticuloMasVendido(
                        (Long) entity[0],
                        (String) entity[1],
                        (BigDecimal) entity[2]
                );

                dtos.add(dto);
            }

            return dtos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<DTOManufacturadoRubro> obtenerManufacturadosConRubroYEstado() throws Exception {
        try {
            List<Object[]> resultados = articuloManufacturadoRepository.obtenerManufacturadosConRubroYEstado();
            List<DTOManufacturadoRubro> dtos = new ArrayList<>();

            for (Object[] resultado : resultados) {
                DTOManufacturadoRubro dto = new DTOManufacturadoRubro(
                        (Long) resultado[0],
                        (String) resultado[1],
                        (String) resultado[2],
                        EstadoAB.valueOf((String) resultado[3])
                );

                dtos.add(dto);
            }
            return dtos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}