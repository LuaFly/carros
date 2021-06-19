package com.luana.carrozup.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luana.carrozup.model.Carro;
import com.luana.carrozup.model.Cliente;
import com.luana.carrozup.repository.CarroRepository;
import com.luana.carrozup.repository.ClienteRepository;

@Configuration
public class instantiation implements CommandLineRunner{
	@Autowired CarroRepository carroRepository;
	@Autowired ClienteRepository clienteRepository;
	@Override
	public void run(String... args) throws Exception{
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Cliente lucas = new Cliente(null, "Lulu", "lulu1@gmail.com", "14526974125",  sdf.parse("21/03/1999"));
		Cliente luana = new Cliente(null, "Luana", "luafly98@gmail.com", "45905277826", sdf.parse("19/10/1998"));
		clienteRepository.saveAll(Arrays.asList(lucas, luana));

		Carro ka = new Carro(null, "chevrolet", "ka", "2011");
		Carro fiesta = new Carro(null, "ford", "fiesta", "2012");
		carroRepository.saveAll(Arrays.asList(ka, fiesta));
			
		luana.getCarro().addAll(Arrays.asList(ka, fiesta));
		clienteRepository.save(luana);
	}

}
