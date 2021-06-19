package com.luana.carrozup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luana.carrozup.model.Carro;

@Repository
public interface CarroRepository extends MongoRepository<Carro, String> {
	
	

}
