package com.loki.common.web.resource;

import com.loki.common.service.IGenericService;
import com.loki.common.validator.GenericValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;

/**
 * @author palmurugan
 * @param <D>
 * @param <K>
 */
public abstract class BaseRestResource<D, K> {

    private IGenericService<D, K> genericService;

    private GenericValidator<D> genericValidator;

    public BaseRestResource(IGenericService genericService, GenericValidator genericValidator) {
        this.genericService = genericService;
        this.genericValidator = genericValidator;
    }

    @PostMapping
    public ResponseEntity<D> create(@Valid @RequestBody D dto) {
        invokeValidation(genericValidator, dto);
        return new ResponseEntity<>(genericService.saveOrUpdate(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<D>> findAll(Pageable pageable) {
        return new ResponseEntity<>(genericService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> find(@PathVariable K id) {
        Optional<D> result = genericService.findByKey(id);
        return new ResponseEntity<>(result.isPresent() ? result.get() : null, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable K id, @Valid @RequestBody D dto) {
        invokeValidation(genericValidator, dto);
        return new ResponseEntity<>(genericService.saveOrUpdate(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable K id) {
        genericService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void invokeValidation(GenericValidator<D> genericValidator, D dto) {
        if(Objects.nonNull(genericValidator))
            genericValidator.validate(dto);
    }
}
