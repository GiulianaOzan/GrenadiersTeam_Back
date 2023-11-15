package com.utn.sprint3.dtos;

import com.utn.sprint3.enums.EstadoAB;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class DTOInsumoRubro {
    private Long id;
    private String insumoDenominacion;
    private String rubroDenominacion;
    private String rubroPadreDenominacion;

    @Enumerated(EnumType.STRING)
    private EstadoAB rubroEstado;

    // Getters y Setters
}