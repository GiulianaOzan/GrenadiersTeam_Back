package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.DetalleFactura;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.services.DetalleFacturaServiceImpl;
import com.utn.sprint3.services.PedidoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detallesfacturas")
public class DetalleFacturaController extends BaseControllerImpl<DetalleFactura, DetalleFacturaServiceImpl>{
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam Integer numero) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(numero));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }

    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam Integer numero, Pageable pageable) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(numero, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }
    }
}

