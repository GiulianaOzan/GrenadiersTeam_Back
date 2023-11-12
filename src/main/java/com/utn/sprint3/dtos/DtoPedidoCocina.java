package com.utn.sprint3.dtos;

import com.utn.sprint3.enums.EstadoPedido;

import java.util.List;

public class DtoPedidoCocina {
    private Long numeroPedido;
    private EstadoPedido estado;
    private List<DtoDetallePedido> detalles;

    public DtoPedidoCocina(Long numeroPedido, EstadoPedido estado, List<DtoDetallePedido> detalles) {
        this.numeroPedido = numeroPedido;
        this.estado = estado;
        this.detalles = detalles;
    }

    public Long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public List<DtoDetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DtoDetallePedido> detalles) {
        this.detalles = detalles;
    }

    public static class DtoDetallePedido {
        private int cantidadPedida;
        private DtoArticulo articulo;

        public DtoDetallePedido(int cantidadPedida, DtoArticulo articulo) {
            this.cantidadPedida = cantidadPedida;
            this.articulo = articulo;
        }

        public int getCantidadPedida() {
            return cantidadPedida;
        }

        public void setCantidadPedida(int cantidadPedida) {
            this.cantidadPedida = cantidadPedida;
        }

        public DtoArticulo getArticulo() {
            return articulo;
        }

        public void setArticulo(DtoArticulo articulo) {
            this.articulo = articulo;
        }
    }

    public static class DtoArticulo {
        private String denominacionArticulo;

        public DtoArticulo(String denominacionArticulo) {
            this.denominacionArticulo = denominacionArticulo;
        }

        public String getDenominacionArticulo() {
            return denominacionArticulo;
        }

        public void setDenominacionArticulo(String denominacionArticulo) {
            this.denominacionArticulo = denominacionArticulo;
        }
    }
}
