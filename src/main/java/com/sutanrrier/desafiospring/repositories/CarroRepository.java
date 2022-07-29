package com.sutanrrier.desafiospring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sutanrrier.desafiospring.entities.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

	@Query("FROM Carro c INNER JOIN c.estacionamento e WHERE e.id = ?1 ORDER BY c.id")
	List<Carro> findAllByEstacionamento(Integer id);
}
