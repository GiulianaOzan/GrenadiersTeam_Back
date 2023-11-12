package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.ArticuloManufacturado;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.services.ArticuloManufacturadoServiceImpl;
import com.utn.sprint3.services.PedidoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/articulomanufacturados")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoServiceImpl>{

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
//    @GetMapping("/listarProductos")
//    public ResponseEntity<?> search() {
//
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(servicio.filtradoPorProductoVendido());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
//        }
//
//    }
//
//    @GetMapping("/listarProductosFecha")
//    public ResponseEntity<?> search(@RequestParam Date fecha1, Date fecha2) {
//
//        try {
//            // Convertir java.util.Date a java.sql.Date
//            java.sql.Date sqlFecha1 = new java.sql.Date(fecha1.getTime());
//            java.sql.Date sqlFecha2 = new java.sql.Date(fecha2.getTime());
//            return ResponseEntity.status(HttpStatus.OK).body(servicio.filtradoPorProductoVendidoPorFecha(sqlFecha1, sqlFecha2));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
//        }
//
//    }



    @GetMapping("/filtradosPorFecha")
    public ResponseEntity<?> filtradoPorProductoVendidoPorFecha(@RequestParam String fecha1, String fecha2) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.servicio.filtradoPorProductoVendidoPorFecha(fecha1, fecha2));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }


}
