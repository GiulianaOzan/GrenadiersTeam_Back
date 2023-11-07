package com.utn.sprint3.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCliente {
    private String nombre;

    private String apellido;

    private String telefono;

    private String email;
}
