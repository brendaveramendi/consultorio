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

import com.blimop.model.Tratamiento;
import com.blimop.service.ITratamientoService;



@RestController
@RequestMapping ("/tratamiento")

public class TratamientoController {

	@Autowired
	private ITratamientoService service;
	
	
	@GetMapping(value = "/listar" , produces = "application/json")
	
	public ResponseEntity<List<Tratamiento>> listar() {
		List<Tratamiento> lista = new ArrayList<>();
		try {
				lista = service.listar();
		}catch (Exception e) {
			
			return new ResponseEntity<List <Tratamiento>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<List <Tratamiento>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tratamiento> listarId(@PathVariable("id") Long id) {
		Tratamiento tratamiento = new Tratamiento();
		try {
			tratamiento= service.listarId(id);
		}catch (Exception e) {
			
			return new ResponseEntity<Tratamiento>(tratamiento, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity <Tratamiento>(tratamiento, HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar",consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody Tratamiento tratamiento) {
		int resultado=0;
		try {
				service.registrar(tratamiento);
				resultado =1;
		}catch (Exception e) {
			
			return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity <Integer>(resultado, HttpStatus.OK);
	}
	
	@PutMapping(value = "/actualizar",consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar (@RequestBody Tratamiento tratamiento) {
		int resultado=0;
		try {
				service.modificar(tratamiento);
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
