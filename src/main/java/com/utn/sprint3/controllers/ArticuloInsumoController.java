package com.utn.sprint3.controllers;

import com.utn.sprint3.dtos.DTOInsumoRubro;
import com.utn.sprint3.entidades.Articulo_Insumo;
import com.utn.sprint3.entidades.Articulo_Insumo;
import com.utn.sprint3.services.ArticuloInsumoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/articulosinsumos")
public class ArticuloInsumoController extends BaseControllerImpl<Articulo_Insumo, ArticuloInsumoServiceImpl> {


    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }

    }
    @GetMapping("/insumosConRubrosYEstados")
    public ResponseEntity<?> obtenerInsumosConRubrosYEstados() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.servicio.obtenerInsumosConRubrosYEstados());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }


}