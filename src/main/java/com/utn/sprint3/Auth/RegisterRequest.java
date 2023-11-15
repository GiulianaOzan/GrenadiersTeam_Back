package com.utn.sprint3.Auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String username;
    String password;
    String auth0Id;
    String email;
}

//Atributos que van a figuran en el registro al momento de crear en el postman S