package com.utn.sprint3.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import com.utn.sprint3.enums.EstadoAB;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class DTOManufacturadoRubro {

    private Long idArticuloManufacturado;
    private String denominacionArticuloManufacturado;
    private String denominacionRubroGeneral;

    @Enumerated(EnumType.STRING)
    private EstadoAB rubroEstado;

}


