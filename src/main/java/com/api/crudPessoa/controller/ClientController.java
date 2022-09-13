package com.api.crudPessoa.controller;

import java.util.List;

import com.api.crudPessoa.model.Cliente;
import com.api.crudPessoa.servico.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.crudPessoa.model.Pessoa;
import com.api.crudPessoa.repositories.PersonRepository;

import javax.validation.Valid;

import javax.validation.Valid;

@RestController
public class ClientController {
    @Autowired
    private PersonRepository action;

    @Autowired
    private Servico service;

    @PostMapping("/api")
    public ResponseEntity<?> signUp(@RequestBody Pessoa pessoa) {
        return service.signUp(pessoa);
    }

    @GetMapping("/api")
    public ResponseEntity<?> selectAll() {
        return service.selectAll();
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<?> selectById(@PathVariable int id) {
        return service.selectById(id);
    }

    @PutMapping("/api")
    public ResponseEntity<?> editPerson(@RequestBody Pessoa obj) {
        return service.editPerson(obj);
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<?> removePerson(@PathVariable int id) { return service.removePerson(id); }

    @PostMapping("/cliente")
    public void Client(@Valid @RequestBody Cliente obj){}
}
