package com.nttdata.bootcamp.bank.operation.controller;

import com.nttdata.bootcamp.bank.operation.model.document.PassiveOperation;
import com.nttdata.bootcamp.bank.operation.service.inte.PassiveOperationServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/passiveoperations")
public class PassiveOperationController {

    private static final Logger log = LoggerFactory.getLogger(PassiveOperationServiceInte.class);

    @Autowired
    private PassiveOperationServiceInte passiveOperationServiceInte;

    @PostMapping
    public Mono<PassiveOperation> create(@RequestBody final PassiveOperation passiveOperation) {
        log.debug("Begin RestController create PassiveOperation");
        return passiveOperationServiceInte.create(passiveOperation);
    }

    @GetMapping
    public Flux<PassiveOperation> readAll() {
        log.debug("Begin RestController readAll PassiveOperation");
        return passiveOperationServiceInte.readAll();
    }

    @GetMapping("/findByCodePassiveOperation/{codePassiveOperation}")
    public Mono<PassiveOperation> readByCodePassiveOperation(@PathVariable String codePassiveOperation) {
        log.debug("Begin RestController readByCodeProduct PassiveOperation");
        return passiveOperationServiceInte.readByCodePassiveOperation(codePassiveOperation);
    }

    @PutMapping("/{id}")
    public Mono<PassiveOperation> updateById(@RequestBody final PassiveOperation passiveOperation, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById PassiveOperation");
        return passiveOperationServiceInte.updateById(id, passiveOperation);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById PassiveOperation");
        return passiveOperationServiceInte.deleteById(id);
    }

}