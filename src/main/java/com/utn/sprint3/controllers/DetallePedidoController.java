package com.utn.sprint3.controllers;

import com.utn.sprint3.dtos.DtoArticuloMasVendido;
import com.utn.sprint3.entidades.DetallePedido;
import com.utn.sprint3.services.DetallePedidoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detallespedidos")
public class DetallePedidoController extends BaseControllerImpl<DetallePedido, DetallePedidoServiceImpl>{
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

//    @GetMapping("/getArticulosMasVendidos")
//    public List<DtoArticuloMasVendido> getArticulosMasVendidos() {
//        return servicio.findArticulosMasVendidos();
//    }
}

