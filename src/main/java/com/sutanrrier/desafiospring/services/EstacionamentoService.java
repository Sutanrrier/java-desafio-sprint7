package com.sutanrrier.desafiospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutanrrier.desafiospring.entities.Estacionamento;
import com.sutanrrier.desafiospring.repositories.EstacionamentoRepository;

@Service
public class EstacionamentoService {
	
	@Autowired
	private EstacionamentoRepository repository;
	
	public List<Estacionamento> findAll(){
		return repository.findAll();
	}
	
	public Optional<Estacionamento> findById(Integer id){
		return repository.findById(id);
	}
	
	public Estacionamento save(Estacionamento estacionamento) {
		return repository.save(estacionamento);
	}
}