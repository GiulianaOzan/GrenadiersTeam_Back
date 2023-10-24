package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Cliente;
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

    // boolean existsByDni( int dni);

    //anotacion jpql parmetros indexados
    @Query(value = "SELECT p FROM Cliente p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro% ")
    List<Cliente> search(String filtro);

    @Query(value = "SELECT p FROM Cliente p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro% ")
    Page<Cliente> search(String filtro,Pageable pageable);

    //anotacion jpql parmetros nombrados

    // @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%:filtro%' OR p.apellido LIKE '%:filtro%'")
    //List<Persona> serach(@Param("filtro") String filtro);

    //Query nativo

    @Query(
            value = "SELECT * FROM Cliente WHERE persona.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro% ",
            nativeQuery = true
    )
    List<Cliente> searchNativo(String filtro);


    @Query(
            value = "SELECT * FROM Cliente WHERE persona.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro% ",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Cliente> searchNativo(String filtro, Pageable pageable );
}
