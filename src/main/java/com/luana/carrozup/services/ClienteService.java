package com.luana.carrozup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.luana.carrozup.dto.ClienteDTO;
import com.luana.carrozup.model.Cliente;
import com.luana.carrozup.repository.ClienteRepository;
import com.luana.carrozup.services.exception.ObjectBadRequest;
import com.luana.carrozup.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public List<Cliente> findAll(){
		return repo.findAll();
		
	}
	public Cliente findById(String id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Cliente insert(Cliente obj) {
		return repo.insert(obj);	
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		if ((objDto.getNome() == "") || (objDto.getEmail() == "") || (objDto.getCpf() == "")) {
			throw new ObjectBadRequest("Verifique os campos obrigatórios");
		}
		return new Cliente(objDto.getId(),objDto.getNome(), objDto.getEmail(), objDto.getCpf(), objDto.getDataNasc());
	}
}
