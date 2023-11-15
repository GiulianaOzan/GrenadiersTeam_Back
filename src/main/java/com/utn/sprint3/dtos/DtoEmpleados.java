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
@AllArgsConstructor(access = AccessLevel.PUBLIC)

public class DtoEmpleados {
    private long id;
    private String id_Empleado;
    private String username_Empleado;

    @Enumerated(EnumType.STRING)
    private Rol rol_Empleado;
    private String email_Empleado;

    private String nombre_Empleado;

    private String apellido_Empleado;

    private String localidad_Empleado;
    private String calle_Empleado;
    private int nro_direccion_Empleado;
    private String contraseña_Empleado;
    private long telefono_Empleado;
}
