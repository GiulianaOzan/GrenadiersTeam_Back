package com.utn.sprint3.Auth;

import com.utn.sprint3.Jwt.JwtService;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.enums.Rol;
import com.utn.sprint3.repositorios.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }

    public AuthResponse register(RegisterRequest request) {
        Usuario usuario = Usuario.builder()
                .username(request.getUsername()) //lo tenemos en el request de la peti, entonces lo obtenemos directamente
                .password(passwordEncoder.encode(request.getPassword()))
                .auth0Id(request.auth0Id)
                .email(request.email)
                .rol(Rol.Cliente)
                .build();
        usuarioRepository.save(usuario); //insertamos el nuevo registro en la BBDD

        //retornamos objeto tipo AuthResponse. Obtenemos el token a traves del servicio JWT
        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }
}
