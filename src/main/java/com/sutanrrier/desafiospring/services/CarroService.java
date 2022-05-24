package com.sutanrrier.desafiospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutanrrier.desafiospring.entities.Carro;
import com.sutanrrier.desafiospring.repositories.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository repository;
	
	public List<Carro> findAll(){
		return repository.findAll();
	}
	
	public Optional<Carro> findById(Integer id) {
		return repository.findById(id);
	}
	
	public Carro save(Carro carro) {
		return repository.save(carro);
	}
}
