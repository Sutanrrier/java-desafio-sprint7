package com.sutanrrier.desafiospring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sutanrrier.desafiospring.entities.Estacionamento;
import com.sutanrrier.desafiospring.services.EstacionamentoService;

@RestController
@RequestMapping(value="/estacionamentos")
public class EstacionamentoController {

	@Autowired
	private EstacionamentoService service;
	
	@GetMapping
	public ResponseEntity<List<Estacionamento>> getAllEstacionamentos(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
}
