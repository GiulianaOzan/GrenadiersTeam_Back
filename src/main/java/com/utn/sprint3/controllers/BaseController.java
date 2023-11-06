package com.utn.sprint3.controllers;
import com.utn.sprint3.entidades.BaseEntidad;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseController<E extends BaseEntidad, ID extends Serializable> {
    ResponseEntity<?> getAll();

    ResponseEntity<?> getAll(Pageable pageable);

    ResponseEntity<?> getOne(ID id);

    ResponseEntity<?> save(E entity);

    ResponseEntity<?> update(ID id, E entity);

    ResponseEntity<?> delete(ID id);
}

