package com.api.crudPessoa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.crudPessoa.model.Pessoa;
@Repository
public interface PersonRepository extends CrudRepository<Pessoa, Integer> {

    Pessoa findById(int id);

    int countById(int id);
}
