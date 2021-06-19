package com.luana.carrozup.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.context.annotation.Lazy;

import com.luana.carrozup.model.Carro;
import com.luana.carrozup.model.Cliente;

public class ClienteDTO {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private String id;
	 
	 private String nome;
	    
	 @Column(unique = true, nullable = false)
	 @Email
	 private String email;

	 @Column(unique = true, nullable = false)
	 @CPF
	 private String cpf;

	 private Date dataNasc;
	 
	 private List<Carro> carro = new ArrayList<>();
	 
	 
	 public ClienteDTO() {
		 
	 }

	 public ClienteDTO(Cliente obj) {
			id = obj.getId();
			nome = obj.getNome();
			email = obj.getEmail();
			cpf = obj.getCpf();
			dataNasc = obj.getDataNasc();	
			carro = obj.getCarro();
	 }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@NotNull(message = "Nome é obrigatório")
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	@NotNull(message = "E-mail é obrigatório")
	@Column(unique = true, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@NotNull(message = "CPF é obrigatório")
	@Column(unique = true, nullable = false)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public List<Carro> getCarro() {
		return carro;
	}

	public void setCarro(List<Carro> carro) {
		this.carro = carro;
	}
	 
	
	 
}
