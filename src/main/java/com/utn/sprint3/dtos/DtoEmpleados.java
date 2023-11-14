package com.utn.sprint3.dtos;

import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.enums.Rol;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class DtoEmpleados {

    private Long id_Empleado;
    private String username_Empleado;

    @Enumerated(EnumType.STRING)
    private Rol rol;
    private String email_Empleado;
}
