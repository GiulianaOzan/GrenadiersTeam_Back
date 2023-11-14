package com.utn.sprint3.dtos;

import com.utn.sprint3.enums.EstadoAB;

public class DTOInsumoRubro {
    private String insumoDenominacion;
    private String rubroDenominacion;
    private String rubroPadreDenominacion;
    private EstadoAB rubroEstado;

    // Getters y Setters

    public String getInsumoDenominacion() {
        return insumoDenominacion;
    }

    public void setInsumoDenominacion(String insumoDenominacion) {
        this.insumoDenominacion = insumoDenominacion;
    }

    public String getRubroDenominacion() {
        return rubroDenominacion;
    }

    public void setRubroDenominacion(String rubroDenominacion) {
        this.rubroDenominacion = rubroDenominacion;
    }

    public String getRubroPadreDenominacion() {
        return rubroPadreDenominacion;
    }

    public void setRubroPadreDenominacion(String rubroPadreDenominacion) {
        this.rubroPadreDenominacion = rubroPadreDenominacion;
    }

    public EstadoAB getRubroEstado() {
        return rubroEstado;
    }

    public void setRubroEstado(EstadoAB rubroEstado) {
        this.rubroEstado = rubroEstado;
    }
}
