package com.sutanrrier.desafiospring.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sutanrrier.desafiospring.entities.Carro;
import com.sutanrrier.desafiospring.repositories.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository repository;
	
	public Page<Carro> findAll(Integer page){
		Sort sort = Sort.by("id").ascending();
		Pageable pageable = PageRequest.of(page, 5, sort);
		
		return repository.findAll(pageable);
	}
	
	public Optional<Carro> findById(Integer id) {
		return repository.findById(id);
	}
	
	@Transactional
	public Carro save(Carro carro) {
		return repository.save(carro);
	}
	
	@Transactional
	public void delete(Carro carro) {
		repository.delete(carro);
	}
}
