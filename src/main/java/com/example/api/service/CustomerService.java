package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.domain.Cidade;
import com.example.api.domain.Customer;
import com.example.api.domain.Endereco;
import com.example.api.repository.CustomerRepository;
import com.example.api.repository.EnderecoRepository;

@Service
public class CustomerService {

	private CustomerRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> findAll() {
		return repository.findAllByOrderByNameAsc();
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public Customer insert(Customer customer) {
		customer.setId(null);
		customer = repository.save(customer);
		enderecoRepository.saveAll(customer.getEnderecos());
		return customer;
	}
	
	public Customer update(Customer customer) {
		 findById(customer.getId());
		 return customer = repository.save(customer);
		 
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
				
	}
	
	
	
	
	
}
