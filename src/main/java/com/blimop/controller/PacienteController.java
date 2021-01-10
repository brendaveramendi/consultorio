package com.blimop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blimop.model.Paciente;
import com.blimop.service.IPacienteService;

@RestController
@RequestMapping ("/paciente")

public class PacienteController {
	@Autowired
	private IPacienteService service;
	
	
	@GetMapping(value = "/listar" , produces = "application/json")
	
	public ResponseEntity<List<Paciente>> listar() {
		List<Paciente> lista = new ArrayList<>();
		try {
				lista = service.listar();
		}catch (Exception e) {
			
			return new ResponseEntity<List <Paciente>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<List <Paciente>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Paciente> listarId(@PathVariable("id") Long id) {
		Paciente paciente = new Paciente();
		try {
			paciente = service.listarId(id);
		}catch (Exception e) {
			
			return new ResponseEntity<Paciente>(paciente, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity <Paciente>(paciente, HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar",consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Paciente> registrar(@RequestBody Paciente paciente) {
		
		Paciente pac = new Paciente();
		
		try {
				pac = service.registrar(paciente);
				
		}catch (Exception e) {
			
			return new ResponseEntity<Paciente>(pac, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity <Paciente>(pac, HttpStatus.OK);
	}
	
	@PutMapping(value = "/actualizar",consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar (@RequestBody Paciente paciente) {
		int resultado=0;
		try {
				service.modificar(paciente);
				resultado =1;
		}catch (Exception e) {
			
			return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity <Integer>(resultado, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> eliminar (@PathVariable Long id) {
		int resultado=0;
		try {
				service.eliminar(id);
				resultado =1;
		}catch (Exception e) {
			
			return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity <Integer>(resultado, HttpStatus.OK);
	}

	

}
