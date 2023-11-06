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

    @GetMapping("/searchByTipoEnvio")
    public ResponseEntity<?> searchByTipoEnvio(@RequestParam String filtro) {
        try {
            TipoEnvio tipoEnvio = TipoEnvio.valueOf(filtro);
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByTipoEnvio(tipoEnvio));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"TipoEnvio no válido: " + filtro + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByTipoEnvioPaged")
    public ResponseEntity<?> searchByTipoEnvio(@RequestParam String filtro, Pageable pageable) {
        try {
            TipoEnvio tipoEnvio = TipoEnvio.valueOf(filtro);
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByTipoEnvio(tipoEnvio, pageable));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"TipoEnvio no válido: " + filtro + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    //Estado pedido
    @GetMapping("/searchByEstadoPedido")
    public ResponseEntity<?> searchByEstadoPedido(@RequestParam String filtro) {
        try {
            EstadoPedido estado = EstadoPedido.valueOf(filtro);
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByEstadoPedido(estado));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Estado no válido: " + filtro + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByEstadoPedidoPaged")
    public ResponseEntity<?> searchByEstadoPedido(@RequestParam String filtro, Pageable pageable) {
        try {
            EstadoPedido estado = EstadoPedido.valueOf(filtro);
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByEstadoPedido(estado, pageable));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Estado no válido: " + filtro + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    //


   // @GetMapping("/search1Paged")
    //public ResponseEntity<?> search1(@RequestParam String filtro, Pageable pageable) {
      //  TipoEnvio tipoEnvio = TipoEnvio.Delivery; // Valor predeterminado si no se proporciona un valor válido

      //  if (filtro != null && !filtro.isEmpty()) {
        //    try {
          //      tipoEnvio = TipoEnvio.valueOf(filtro);
            //} catch (IllegalArgumentException e) {
              //  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de envío no válido");
       //     }
       // }

        //try {
         //   return ResponseEntity.status(HttpStatus.OK).body(servicio.search1(tipoEnvio, pageable));
        //} catch (Exception e) {
         //   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
       // }
   // }
}
