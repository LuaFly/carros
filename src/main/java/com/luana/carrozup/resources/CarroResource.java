package com.luana.carrozup.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpStatus;

import com.luana.carrozup.dto.CarroDTO;
import com.luana.carrozup.model.Carro;
import com.luana.carrozup.services.CarroService;

@RestController
@RequestMapping(value="/carros")
public class CarroResource {
	@Autowired
	private CarroService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CarroDTO>> findAll(){
		List<Carro> list =  service.findAll();
		List<CarroDTO> listDTO = list.stream().map(x -> new CarroDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO );
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<CarroDTO> findById(@PathVariable String id){
		Carro obj = service.findById(id);
		return ResponseEntity.ok().body(new CarroDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert( @RequestBody CarroDTO objDto){
		Carro obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
