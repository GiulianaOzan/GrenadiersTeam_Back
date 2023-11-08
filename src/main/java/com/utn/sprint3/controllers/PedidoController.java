package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.enums.EstadoPedido;
import com.utn.sprint3.enums.TipoEnvio;
import com.utn.sprint3.services.PedidoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/v1/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl> {
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam Date fechafiltro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(fechafiltro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam Date fechafiltro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(fechafiltro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
// Tipo Envio
    @GetMapping("/searchByTipoEnvio")
    public ResponseEntity<?> searchByTipoEnvio(@RequestParam String tipoenvio) {
        try {
            TipoEnvio tipoEnvio = TipoEnvio.valueOf(tipoenvio);
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByTipoEnvio(tipoEnvio));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Tipo Envio no válido: " + tipoenvio + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByTipoEnvioPaged")
    public ResponseEntity<?> searchByTipoEnvio(@RequestParam String tipoenvio, Pageable pageable) {
        try {
            TipoEnvio tipoEnvio = TipoEnvio.valueOf(tipoenvio);
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByTipoEnvio(tipoEnvio, pageable));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Tipo Envio no válido: " + tipoenvio + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    //Estado pedido
    @GetMapping("/searchByEstado")
    public ResponseEntity<?> searchByEstadoPedido(@RequestParam String Estado) {
        try {
            EstadoPedido estado = EstadoPedido.valueOf(Estado);
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByEstadoPedido(estado));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Estado no válido: " + Estado + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByEstadoPaged")
    public ResponseEntity<?> searchByEstadoPedido(@RequestParam String Estado, Pageable pageable) {
        try {
            EstadoPedido estado = EstadoPedido.valueOf(Estado);
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByEstadoPedido(estado, pageable));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Estado no válido: " + Estado + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
    


}
