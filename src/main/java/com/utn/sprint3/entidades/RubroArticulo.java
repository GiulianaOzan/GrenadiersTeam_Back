package com.utn.sprint3.entidades;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "rubro_articulo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RubroArticulo extends BaseEntidad {

    //@ManyToOne
    //@JoinColumn(name = "id_rubro_padre")
    //private RubroArticulo rubroPadre;

    //@OneToMany(mappedBy = "rubroPadre")
    //private List<RubroArticulo> subRubros;

    @NotNull
    private String denominacion;

    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;

    @ManyToOne
    @JoinColumn(name = "id_rubro_padre")
    private RubroArticulo rubroPadre;

    @OneToMany(mappedBy = "rubroPadre")
    private List<RubroArticulo> subRubros;
}
