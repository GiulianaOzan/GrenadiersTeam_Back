package com.utn.sprint3.Auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    String username;
    String password;
}

//tenemos que especificar como nuestro controller va a esperar los
// request y response, para eso creamos 3 clases.
// Login es una de ellas y esta clase pide las credenciales (username y password)
