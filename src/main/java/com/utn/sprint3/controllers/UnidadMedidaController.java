package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.UnidadMedida;
import com.utn.sprint3.services.UnidadMedidaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/unidadmedidas")
public class UnidadMedidaController extends BaseControllerImpl <UnidadMedida, UnidadMedidaServiceImpl>{
}
