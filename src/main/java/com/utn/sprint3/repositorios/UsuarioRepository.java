package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.Pedido;
import com.utn.sprint3.entidades.Usuario;

import com.utn.sprint3.enums.EstadoPedido;
import com.utn.sprint3.enums.Rol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository <Usuario,Long> {
    Optional<Usuario> findByUsername( String username);
    Page<Usuario> findByUsername(String username, Pageable pageable);
    List<Usuario> findByRol(Rol rol);
    Page<Usuario> findByRol(Rol rol, Pageable pageable);



    //anotacion jpql parmetros indexados
    @Query(value = "SELECT u FROM Usuario u WHERE u.username LIKE %:username%")
    List<Usuario> search(String username);

    @Query(value = "SELECT u FROM Usuario u WHERE u.username LIKE %:username%")
    Page<Usuario> search(String username, Pageable pageable);

    @Query(
            value = "SELECT * FROM Usuario WHERE usuario.username LIKE %:username%",
            nativeQuery = true
    )
    List<Usuario> searchNativo(@Param("username") String username);

    @Query(
            value = "SELECT * FROM Usuario WHERE usuario.username LIKE %:username%",
            nativeQuery = true
    )
    Page<Usuario> searchNativo(@Param("username") String username, Pageable pageable);

    //Query nativo

    @Query("SELECT u FROM Usuario u WHERE u.rol = :rol")
    List<Usuario> searchByRol(@Param("rol") Rol rol);

    @Query("SELECT u FROM Usuario u WHERE u.rol = :rol")
    Page<Usuario> searchByRol(@Param("rol") Rol rol, Pageable pageable);

    //Consulta nativa
    @Query(
            value = "SELECT * FROM Usuario WHERE usuario.rol = :rol",
            nativeQuery = true
    )
    List<Usuario> searchNativo(@Param("rol") Rol rol);

    @Query(
            value = "SELECT * FROM Usuario WHERE usuario.rol = :rol",
            nativeQuery = true
    )
    Page<Usuario> searchNativo(@Param("rol") Rol rol, Pageable pageable);

    @Query(value = "SELECT\n" +
            "    u.id AS id_Empleado,\n" +
            "    u.username As username_Empleado,\n" +
            "    u.rol AS rol,\n" +
            "    u.email AS email_Empleado\n" +
            "FROM\n" +
            "    Usuario u\n" +
            "WHERE\n" +
            "    u.rol <> 'Cliente'", nativeQuery = true)
    List<Object[]> obtenerEmpleadosExceptoClientes();


}