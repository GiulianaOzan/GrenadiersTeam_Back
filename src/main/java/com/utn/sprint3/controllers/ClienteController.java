package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.services.ClienteServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl>{
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String DatoCliente) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(DatoCliente));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }

    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String DatoCliente, Pageable pageable) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(DatoCliente, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }

    }
}
