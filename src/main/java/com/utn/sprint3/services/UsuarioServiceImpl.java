package com.utn.sprint3.services;

import com.utn.sprint3.dtos.DtoEmpleados;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.enums.Rol;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository,UsuarioRepository usuarioRepository) {
        super(baseRepository);
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public List<Usuario> search(String username) throws Exception {
        try{
            //List<Usuario> usuarios = usuarioRepository.findByUsername(filtro);
            List<Usuario> usuarios = usuarioRepository.search(username);
            //List<Usuario> usuarios = usuarioRepository.search(filtro);
            return usuarios;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    public Page<Usuario> search(String username, Pageable pageable) throws Exception {
        try{
            Page<Usuario> usuarios = usuarioRepository.search(username, pageable);
            return usuarios;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Usuario por Rol
    @Override
    public List<Usuario> searchByRol(Rol rol) throws Exception {
        try {
            return usuarioRepository.searchByRol(rol);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Usuario> searchByRol(Rol rol, Pageable pageable) throws Exception {
        try {
            return usuarioRepository.searchByRol(rol, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

/*    public List<DtoEmpleados> obtenerEmpleadosExceptoClientes() {
        try {
            Rol clienteRol = Rol.Cliente;
            List<Object[]> entities = usuarioRepositorio.findAllExceptClientes(clienteRol.name());
            List<DtoEmpleados> dtos = new ArrayList<>();

            for (Object[] entity : entities) {
                DtoEmpleados dto = new DtoEmpleados(
                        (Long) entity[0],
                        (String) entity[1],
                        (Rol) entity[2], // Asegúrate de que la posición y el tipo sean correctos
                        (String) entity[3]
                );

                dtos.add(dto);
            }

            return dtos;
        } catch (Exception e) {
            // Manejar la excepción según tus necesidades
            e.printStackTrace(); // Imprimir la excepción por ahora, puedes cambiar esto según tus requerimientos.
            return new ArrayList<>(); // Otra opción sería lanzar la excepción o devolver una lista vacía.
        }*/

    @Override
    public List<DtoEmpleados> obtenerEmpleadosExceptoClientes() throws Exception {
        try {
            List<Object[]> entities = usuarioRepository.obtenerEmpleadosExceptoClientes();
            List<DtoEmpleados> dtos = new ArrayList<>();

            for (Object[] entity : entities) {
                DtoEmpleados dto = new DtoEmpleados(
                        (long) entity[0],
                        (String) entity[1],
                        (String) entity[2],
                        Rol.valueOf((String) entity[3]), // Convertir a enumeración
                        (String) entity[4],
                        (String) entity[5],
                        (String) entity[6],
                        (String) entity[7],
                        (String) entity[8],
                        (int) entity[9],
                        (String) entity[10],
                        (long) entity[11]
                );

                dtos.add(dto);
            }

            return dtos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
