package com.blimop.service;

import java.util.List;

import com.blimop.model.Odontologo;

public interface IOdontologoService {

	Odontologo registrar (Odontologo odontologo);
	
	void modificar (Odontologo odontologo);
	
	void eliminar(Long idOdontologo);
	
	Odontologo listarId(Long idOdontologo);
	
	List<Odontologo> listar();

}
