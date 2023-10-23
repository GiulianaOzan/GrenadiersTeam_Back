package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.entidades.MercadoPagoDatos;
import com.utn.sprint3.services.FacturaServiceImpl;
import com.utn.sprint3.services.MercadoPagoDatosServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/mercadopagodatos")
public class MercadoPagoDatosController extends BaseControllerImpl<MercadoPagoDatos, MercadoPagoDatosServiceImpl>{
}
