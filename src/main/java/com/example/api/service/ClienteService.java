package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.api.domain.Cliente;

import com.example.api.repository.ClienteRepository;
import com.example.api.repository.EnderecoRepository;

@Service
public class ClienteService {

	private ClienteRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}
	
	public List<Cliente> findAll() {
		return repository.findAllByOrderByNameAsc();
	}

	public Optional<Cliente> findById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public Cliente insert(Cliente customer) {
		customer.setId(null);
		customer = repository.save(customer);
		enderecoRepository.saveAll(customer.getEnderecos());
		return customer;
	}
	
	public Cliente update(Cliente customer) {
		 findById(customer.getId());
		 return customer = repository.save(customer);
		 
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
				
	}
	
	
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}


	
}
