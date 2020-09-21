package com.example.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {
	
	@Transactional(readOnly=true)
	List<Cliente> findAllByOrderByNameAsc();
	
	@Transactional(readOnly=true)
	public Page<Cliente> findAll(Pageable pageable);

	
	
}
