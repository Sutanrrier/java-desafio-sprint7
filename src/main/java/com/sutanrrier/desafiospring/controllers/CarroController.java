package com.sutanrrier.desafiospring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
		return ResponseEntity.ok().body(service.findAll());
	}
}
