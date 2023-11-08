package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.UnidadMedida;
import com.utn.sprint3.services.UnidadMedidaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/unidadmedidas")
public class UnidadMedidaController extends BaseControllerImpl <UnidadMedida, UnidadMedidaServiceImpl>{
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String DatosUnidadMedida) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(DatosUnidadMedida));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }

    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String DatosUnidadMedida, Pageable pageable) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(DatosUnidadMedida, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }

    }
}
