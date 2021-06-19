package com.luana.carrozup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.luana.carrozup.model.Cliente;


public interface ClienteRepository extends MongoRepository<Cliente, String>{

}
