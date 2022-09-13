package com.api.crudPessoa.servico;

import com.api.crudPessoa.model.Message;
import com.api.crudPessoa.model.Pessoa;
import com.api.crudPessoa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Servico {
    @Autowired
    private Message message;

    @Autowired
    private PersonRepository action;

    //Método par acadastrar pessoas
    public ResponseEntity<?> signUp(Pessoa obj) {
        if(obj.getName().equals("")){
            message.setMessage("O nome precisa ser preenchido");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if(obj.getAge() < 0) {
            message.setMessage("Infomre uma idade válida");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(action.save(obj), HttpStatus.CREATED);
        }
    }

    //Método para selecionar pessoas
    public ResponseEntity<?> selectAll() {
        return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
    }

    //Método para selecionar pessoas através do código
    public ResponseEntity<?> selectById(int id) {
        if(action.countById(id) == 0){ //Conta quantos registros a tabela possui com o Id passado no parâmetro
            message.setMessage("Não foi encontrada nenhuma pessoa");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(action.findById(id), HttpStatus.OK);
        }
    }

    //Método para editar dados
    public ResponseEntity<?> editPerson(Pessoa obj) {
        if(action.countById(obj.getId()) == 0) {
            message.setMessage("Codigo informado não existe");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else if (obj.getName().equals("")){
            message.setMessage("É necessáio informar um nome");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (obj.getAge() < 0) {
            message.setMessage("Informe uma idade válida");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(action.save(obj), HttpStatus.OK);
        }
    }

    //Método para remover serviços
    public ResponseEntity<?> removePerson(int id) {
        if(action.countById(id) == 0){
            message.setMessage("Não foi encontrada nenhuma pessoa");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }else {
            Pessoa obj = action.findById(id);
            action.delete(obj);
            message.setMessage("Pessoa removida com sucesso");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }
}
