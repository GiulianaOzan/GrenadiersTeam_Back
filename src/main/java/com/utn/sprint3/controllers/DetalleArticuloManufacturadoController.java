package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.DetalleArticuloManufacturado;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.services.DetalleArticuloManufacturadoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detallesArticulosManufacturados")
public class DetalleArticuloManufacturadoController extends BaseControllerImpl<DetalleArticuloManufacturado, DetalleArticuloManufacturadoServiceImpl>{
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
