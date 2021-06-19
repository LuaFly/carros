package com.luana.carrozup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luana.carrozup.dto.CarroDTO;
import com.luana.carrozup.model.Carro;
import com.luana.carrozup.repository.CarroRepository;
import com.luana.carrozup.services.exception.ObjectBadRequest;
import com.luana.carrozup.services.exception.ObjectNotFoundException;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository repo;
	
	public List<Carro> findAll(){
		return repo.findAll();
		
	}
	
	public Carro findById(String id) {
		Optional<Carro> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Carro insert(Carro obj) {
		return repo.insert(obj);
		
	}
	
	public Carro fromDTO(CarroDTO objDto) {
		if ((objDto.getMarca() == "") || (objDto.getModel() == "") || (objDto.getAno() == "")) {
			throw new ObjectBadRequest("Verifique os campos obrigatórios");
		}
		if(objDto.getAno().substring(objDto.getAno().length()-1).equals("1")){
			throw new ObjectBadRequest("Verifique os campos obrigatórios");			
			
		}
			
		return new Carro(objDto.getId(), objDto.getMarca(), objDto.getModel(), objDto.getAno());
	}

}
