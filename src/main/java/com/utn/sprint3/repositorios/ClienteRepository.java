package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository <Cliente,Long> {
    List<Cliente> findByNombreAndApellido(String nombre, String apellido);
    Page<Cliente> findByNombreAndApellido(String nombre, String apellido, Pageable pageable);


    //anotacion jpql parmetros indexados
    @Query(value = "SELECT c FROM Cliente c WHERE c.nombre LIKE %:DatoCliente% OR c.apellido LIKE %:DatoCliente% ")
    List<Cliente> search(String DatoCliente);

    @Query(value = "SELECT c FROM Cliente c WHERE c.nombre LIKE %:DatoCliente% OR c.apellido LIKE %:DatoCliente% ")
    Page<Cliente> search(String DatoCliente, Pageable pageable);


    //Query nativo
    @Query(
            value = "SELECT * FROM Cliente WHERE cliente.nombre LIKE %:DatoCliente% OR cliente.apellido LIKE %:DatoCliente%",
            nativeQuery = true
    )
    List<Cliente> searchNativo(String DatoCliente);

    @Query(
            value = "SELECT * FROM Cliente WHERE cliente.nombre LIKE %:DatoCliente% OR cliente.apellido LIKE %:DatoCliente% ",
            nativeQuery = true
    )
    Page<Cliente> searchNativo(String DatoCliente, Pageable pageable);
}
