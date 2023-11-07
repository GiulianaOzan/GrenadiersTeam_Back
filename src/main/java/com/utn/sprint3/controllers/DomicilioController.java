package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.Domicilio;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.services.DomicilioServiceImpl;
import com.utn.sprint3.services.PedidoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/domicilios")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl>{
    @GetMapping("/search")
    public ResponseEntity<?> searchByLocalidad(@RequestParam String filtrolocalidad) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByLocalidad(filtrolocalidad));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }

    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtrolocalidad, Pageable pageable) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByLocalidad(filtrolocalidad, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }

    }

    @GetMapping("/search1")
    public ResponseEntity<?> searchByLocalidad(@RequestParam int filtrocodigoPostal) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByCodigoPostal(filtrocodigoPostal));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }

    }

    @GetMapping("/search1Paged")
    public ResponseEntity<?> search(@RequestParam int filtrocodigoPostal, Pageable pageable) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByCodigoPostal(filtrocodigoPostal, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }

    }

}
