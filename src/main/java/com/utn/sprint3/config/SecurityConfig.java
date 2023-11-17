package com.utn.sprint3.config;

import com.utn.sprint3.Jwt.JwtAuthenticationFilter;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;




import lombok.RequiredArgsConstructor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                .csrf(csrf ->
                        csrf.disable())
                .authorizeHttpRequests(authRequest ->
                                authRequest
                                        //Autenticacion
                                        .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()

                                        //Consola H2:
                                        .requestMatchers(PathRequest.toH2Console()).permitAll()

                                        //Autorizacion de acceso a la url:
                                        //.requestMatchers(new AntPathRequestMatcher("/api/v1/facturas")).hasAnyAuthority("Cliente")
                                        //.requestMatchers(new AntPathRequestMatcher("/api/v1/demoUser/**")).hasAuthority("USER")


                                //Descomentar para poder usar las request en postman de forma libre

                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/articulomanufacturados")).hasAuthority("Cliente")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/articulomanufacturados/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/clientes")).hasAuthority("Cajero")


                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/articulosinsumos/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/articulomanufacturados/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/clientes/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/empleados/**")).hasAuthority("Administrador")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/detallesArticulosManufacturados/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/detallesfacturas/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/detallespedidos/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/domicilios/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/facturas/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/mercadopagodatos/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/pedidos/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/rubrosArticulos/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/rubrosgenerales/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/unidadmedidas/**")).permitAll()


                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/usuarios/**")).permitAll()


                )
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)) //sino no levanta H2?? duda
                .sessionManagement(sessionManager ->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();


    }
    }

