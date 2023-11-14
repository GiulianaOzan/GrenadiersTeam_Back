package com.utn.sprint3.services;

import com.utn.sprint3.dtos.*;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.enums.EstadoPedido;
import com.utn.sprint3.enums.TipoEnvio;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> search(Date fechafiltro) throws Exception {
        try {
            return pedidoRepository.search(fechafiltro);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Pedido> search(Date fechafiltro, Pageable pageable) throws Exception {
        try {
            return pedidoRepository.search(fechafiltro, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Método para filtrar por tipo de envío
    @Override
    public List<DtoPedidoEnvio> searchByTipoEnvio(TipoEnvio tipoEnvio) throws Exception {
        try {
            return pedidoRepository.searchByTipoEnvio(tipoEnvio);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<DtoPedidoEnvio> searchByTipoEnvio(TipoEnvio tipoEnvio, Pageable pageable) throws Exception {
        try {
            return pedidoRepository.searchByTipoEnvio(tipoEnvio, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Método para filtrar por estado del pedido
    @Override
    public List<DtoPedidoEstado> searchByEstadoPedido(EstadoPedido estado) throws Exception {
        try {
            return pedidoRepository.searchByEstadoPedido(estado);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<DtoPedidoEstado> searchByEstadoPedido(EstadoPedido estado, Pageable pageable) throws Exception {
        try {
            return pedidoRepository.searchByEstadoPedido(estado, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<DtoPedidoEstado> findBy() {
        return pedidoRepository.findBy();
    }

    @Override
    public List<DtoMovimientosMonetarios> calcularTotales(String fecha1, String fecha2) throws Exception {
        try {
            List<Object[]> entities = pedidoRepository.calcularTotales(fecha1, fecha2);
            List<DtoMovimientosMonetarios> dtos = new ArrayList<>();

            for (Object[] entity : entities) {
                BigDecimal ingresos = (BigDecimal) entity[0];
                BigDecimal costos = (BigDecimal) entity[1];
                BigDecimal ganancias = (BigDecimal) entity[2];

                // Formatear los valores con dos decimales
                ingresos = ingresos.setScale(2, RoundingMode.HALF_UP);
                costos = costos.setScale(2, RoundingMode.HALF_UP);
                ganancias = ganancias.setScale(2, RoundingMode.HALF_UP);

                DtoMovimientosMonetarios dto = new DtoMovimientosMonetarios(
                        ingresos,
                        costos,
                        ganancias
                );

                dtos.add(dto);
            }

            return dtos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

   /* @Override
    public List<DtoPedidoCocina> ObtenerPedidoCocina() throws Exception {
        try {
            List<Object[]> entities = pedidoRepository.ObtenerPedidoCocina();
            List<DtoPedidoCocina> dtos = new ArrayList<>();

            for (Object[] entity : entities) {
                Long numeroPedido = (Long) entity[0];
                EstadoPedido estado = EstadoPedido.valueOf((String) entity[1]);
                int cantidadPedida = (int) entity[2];
                String denominacionArticulo = (String) entity[3];
                LocalDateTime fechaPedido = (LocalDateTime) entity[4];

                DtoPedidoCocina dto = new DtoPedidoCocina();
                dto.setNumeroPedido(numeroPedido);
                dto.setEstado(estado);

                DtoPedidoCocina.DtoDetallePedido detalle = new DtoPedidoCocina.DtoDetallePedido();
                detalle.setCantidadPedida(cantidadPedida);

                DtoPedidoCocina.DtoArticulo articulo = new DtoPedidoCocina.DtoArticulo();
                articulo.setDenominacionArticulo(denominacionArticulo);

                detalle.setArticulo(articulo);
                dto.setDetalles(Collections.singletonList(detalle));

                dtos.add(dto);
            }

            return dtos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }*/



}
