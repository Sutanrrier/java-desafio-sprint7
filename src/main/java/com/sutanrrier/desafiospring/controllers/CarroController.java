package com.sutanrrier.desafiospring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sutanrrier.desafiospring.entities.Carro;
import com.sutanrrier.desafiospring.services.CarroService;

@RestController
@RequestMapping(value="/carros")
public class CarroController {
	
	@Autowired
	private CarroService service;
	
	@GetMapping
	public ResponseEntity<List<Carro>> getAllCarros(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Object> getCarroById(@PathVariable Integer id){
		Optional<Carro> carro = service.findById(id);
		if(!carro.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado no banco de dados!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(carro.get());
	}
}
