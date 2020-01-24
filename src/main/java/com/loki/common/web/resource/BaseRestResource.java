package com.loki.common.web.resource;

import com.loki.common.service.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

public abstract class BaseRestResource<D, K> {

    private IGenericService<D, K> genericService;

    public BaseRestResource(IGenericService genericService) {
        this.genericService = genericService;
    }

    @PostMapping
    public ResponseEntity<D> create(@Valid @RequestBody D entity) {
        return new ResponseEntity<>(genericService.saveOrUpdate(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<D>> getAll(Pageable pageable) {
        return new ResponseEntity<>(genericService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> get(@PathVariable K id) {
        Optional<D> result = genericService.findByKey(id);
        return new ResponseEntity<>(result.isPresent() ? result.get() : null, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable K id, @Valid @RequestBody D dto) {
        return new ResponseEntity<>(genericService.saveOrUpdate(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable K id) {
        genericService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
