package com.utn.sprint3.entidades;

import com.utn.sprint3.enums.EstadoAB;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "rubro_entidad")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class RubroGeneral extends BaseEntidad{

    private String denominacion;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoAB estadoAB;

}
