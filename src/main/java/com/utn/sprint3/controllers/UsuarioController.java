package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.enums.Rol;
import com.utn.sprint3.services.UsuarioServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String username) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(username));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }

    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String username, Pageable pageable) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(username, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }

    }

    @GetMapping("/searchByRol")
    public ResponseEntity<?> searchByRol(@RequestParam String Rolfiltro) {
        try {
            Rol rol = Rol.valueOf(Rolfiltro);
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByRol(rol));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Rol no válido: " + Rolfiltro + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByRolPaged")
    public ResponseEntity<?> searchByRol(@RequestParam String Rolfiltro, Pageable pageable) {
        try {
            Rol rol = Rol.valueOf(Rolfiltro);
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByRol(rol, pageable));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Rol no válido: " + Rolfiltro + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}
