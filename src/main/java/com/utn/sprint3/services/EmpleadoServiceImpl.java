package com.utn.sprint3.services;
import com.utn.sprint3.entidades.Domicilio;
import com.utn.sprint3.entidades.Empleado;
import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.EmpleadoRepository;
import com.utn.sprint3.repositorios.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl extends BaseServiceImpl<Empleado, Long> implements EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(BaseRepository<Empleado, Long> baseRepository, EmpleadoRepository empleadoRepository) {
        super(baseRepository);
        this.empleadoRepository = empleadoRepository;
    }
}
