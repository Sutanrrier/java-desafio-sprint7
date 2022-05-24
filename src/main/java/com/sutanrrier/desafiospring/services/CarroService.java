package com.sutanrrier.desafiospring.services;

import java.util.List;

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
}