package com.example.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.api.domain.Cidade;
import com.example.api.domain.Customer;
import com.example.api.domain.Endereco;
import com.example.api.domain.Estado;
import com.example.api.repository.CidadeRepository;
import com.example.api.repository.CustomerRepository;
import com.example.api.repository.EnderecoRepository;
import com.example.api.repository.EstadoRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Customer cl = new Customer(null, "Ronaldo", "ronaldo@gmail.com");
		Customer cl1 = new Customer(null, "Mariazinha","mariazinha@email.com");
		Customer cl2 = new Customer(null, "Joãozinho","joaozinho@email.com");
		repository.saveAll(Arrays.asList(cl,cl1,cl2));
		
		Estado est1 = new Estado (null, "Minas Gerais");
		Estado est2 = new Estado (null, "São Paulo");
		
		Cidade c1 = new Cidade (null, "Uberlândia",est1);
		Cidade c2 = new Cidade (null, "São Paulo",est2);
		Cidade c3 = new Cidade (null, "Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c1, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Customer cus = new Customer(null, "Ronaldo Pereira de Lima", "ronaldo.carpeiem12@gmail.com");

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cus, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cus, c2);
		
       cus.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		repository.saveAll(Arrays.asList(cus));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
		
	}   
	
}
