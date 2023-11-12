package com.utn.sprint3.controllers;

import com.utn.sprint3.dtos.DtoCliente;
import com.utn.sprint3.dtos.DtoPedidoEnvio;
import com.utn.sprint3.dtos.DtoPedidoEstado;
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

import static com.utn.sprint3.enums.EstadoPedido.Cocina;
import static com.utn.sprint3.enums.EstadoPedido.Preparacion;

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


    @GetMapping("/findAllPedidosEstado")
    public List<DtoPedidoEstado> findAllPedidosEstado() {
        return servicio.findBy();

    }
    @GetMapping("/filtradosCostos")
    public ResponseEntity<?> calcularTotales(@RequestParam String fecha1, String fecha2) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.servicio.calcularTotales(fecha1, fecha2));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    /*@GetMapping("/PedidosCocina")
    public ResponseEntity<?> ObtenerPedidoCocina() {
        try {
            EstadoPedido estadoPedido = EstadoPedido.Iniciado; // Puedes cambiar esto según tu estructura
            return ResponseEntity.status(HttpStatus.OK).body(this.servicio.ObtenerPedidoCocina());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }*/

   /* @GetMapping("/PedidoCocina")
    public ResponseEntity<?> obtenerPedidosEnCocina() {
        try {
            // Asumiendo que EstadoPedido es un enum y Cocina es un valor válido en ese enum
            EstadoPedido estado = EstadoPedido.Cocina; // Puedes cambiar esto según tu estructura
            List<Pedido> pedidosEnCocina = servicio.searchByEstadoPedido(estado);

            if (!pedidosEnCocina.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(pedidosEnCocina);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se encontraron pedidos en estado de cocina.\"}");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }*/


}
