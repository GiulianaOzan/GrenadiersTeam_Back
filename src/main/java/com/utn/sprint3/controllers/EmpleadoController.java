package com.utn.sprint3.controllers;
import com.utn.sprint3.entidades.Domicilio;
import com.utn.sprint3.entidades.Empleado;
import com.utn.sprint3.services.EmpleadoServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/empleados")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoServiceImpl>{
}
