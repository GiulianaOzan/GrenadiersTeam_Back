package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.DetalleFactura;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.services.DetalleFacturaServiceImpl;
import com.utn.sprint3.services.PedidoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detallesfacturas")
public class DetalleFacturaController extends BaseControllerImpl<DetalleFactura, DetalleFacturaServiceImpl>{
}
