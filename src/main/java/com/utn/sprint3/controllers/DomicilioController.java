package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.Domicilio;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.services.DomicilioServiceImpl;
import com.utn.sprint3.services.PedidoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/domicilios")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl>{
}
