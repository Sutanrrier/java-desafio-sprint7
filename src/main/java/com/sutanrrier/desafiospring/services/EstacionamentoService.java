package com.sutanrrier.desafiospring.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sutanrrier.desafiospring.entities.Estacionamento;
import com.sutanrrier.desafiospring.repositories.EstacionamentoRepository;

@Service
public class EstacionamentoService {
	
	@Autowired
	private EstacionamentoRepository repository;
	
	public Page<Estacionamento> findAll(Integer page){
		Sort sort = Sort.by("id").ascending();
		
		Pageable pageable = PageRequest.of(page, 5, sort);
		
		return repository.findAll(pageable);
	}
	
	public List<Estacionamento> getAllEstacionamentos(){
		return repository.findAll();
	}
	
	public Optional<Estacionamento> findById(Integer id){
		return repository.findById(id);
	}
	
	@Transactional
	public Estacionamento save(Estacionamento estacionamento) {
		return repository.save(estacionamento);
	}
	
	@Transactional
	public void delete(Estacionamento estacionamento) {
		repository.delete(estacionamento);
	}
	
}
