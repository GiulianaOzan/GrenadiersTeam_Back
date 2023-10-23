package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.services.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/clientes")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{


}
