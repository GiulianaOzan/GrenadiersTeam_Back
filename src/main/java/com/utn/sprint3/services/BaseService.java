package com.utn.sprint3.services;

import com.utn.sprint3.entidades.BaseEntidad;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;

public interface BaseService <E extends BaseEntidad, ID extends Serializable> {
    //Trae una lista de todas las entidades que se encuentran en nuestra base de datos
    public List<E> findAll() throws Exception;
    //Busca entidades por Id que le pasamos

    public E findById(ID id) throws Exception;
    //creamos nueva entidad
    public E save(E entity) throws Exception;
    //Actualizamos entidades
    public E update(ID id, E entity) throws Exception;
    //Eliminamos registros
    public  boolean delete(ID id) throws Exception;
}