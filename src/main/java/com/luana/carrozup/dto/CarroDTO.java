package com.luana.carrozup.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.luana.carrozup.model.Carro;
import com.luana.carrozup.model.Cliente;

public class CarroDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@NotNull(message = "Modelo é obrigatório")
	private String model;
	
	@NotNull(message = "Marca é obrigatório")
	private String marca;
	private String ano;
	


	public CarroDTO() {
		
	}
	public CarroDTO(Carro obj) {
		id = obj.getId();
		model = obj.getModel();
		marca = obj.getMarca();
		ano = obj.getAno();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@NotNull(message = "Modelo é obrigatório")
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@NotNull(message = "Marca é obrigatório")
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	@NotNull(message = "Ano é obrigatório")
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}

	
}
