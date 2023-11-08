package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.entidades.RubroArticulo;
import com.utn.sprint3.services.FacturaServiceImpl;
import com.utn.sprint3.services.RubroArticuloServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/rubrosArticulos")
public class RubroArticuloController extends BaseControllerImpl<RubroArticulo, RubroArticuloServiceImpl>{
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String Denominacion) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(Denominacion));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }

    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String Denominacion, Pageable pageable) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(Denominacion, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }

    }
}
