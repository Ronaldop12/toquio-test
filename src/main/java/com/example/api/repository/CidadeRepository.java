package com.example.api.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.domain.Cidade;
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	@Transactional(readOnly=true)
	@Query("SELECT cliente FROM Cidade cliente WHERE cliente.estado.id = :estadoId ORDER BY cliente.nome")
	public List<Cidade> findCidades(@Param("estadoId") Integer estado_id);
}

