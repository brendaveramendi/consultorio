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

import com.blimop.model.Odontologo;
import com.blimop.service.IOdontologoService;

@RestController
@RequestMapping ("/odontologo")
public class OdontologoController {
	
	@Autowired
	private IOdontologoService service;
	
	
	@GetMapping(value = "/listar" , produces = "application/json")
	
	public ResponseEntity<List<Odontologo>> listar() {
		List<Odontologo> lista = new ArrayList<>();
		try {
				lista = service.listar();
		}catch (Exception e) {
			
			return new ResponseEntity<List <Odontologo>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<List <Odontologo>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Odontologo> listarId(@PathVariable("id") Long id) {
		Odontologo odontologo = new Odontologo();
		try {
			odontologo = service.listarId(id);
		}catch (Exception e) {
			
			return new ResponseEntity<Odontologo>(odontologo, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity <Odontologo>(odontologo, HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar",consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Odontologo> registrar(@RequestBody Odontologo odontologo) {
		Odontologo odont = new Odontologo();
		try {
				service.registrar(odontologo);
				
		}catch (Exception e) {
			
			return new ResponseEntity<Odontologo>(odont, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity <Odontologo>(odont, HttpStatus.OK);
	}
	
	@PutMapping(value = "/actualizar",consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar (@RequestBody Odontologo odontologo) {
		int resultado=0;
		try {
				service.modificar(odontologo);
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
