package com.blimop.service;

import java.util.List;

import com.blimop.model.Tratamiento;

public interface ITratamientoService {

	Tratamiento registrar (Tratamiento tratamiento);
	
	void modificar (Tratamiento tratamiento);
	
	void eliminar(Long Tratamiento);
	
	Tratamiento listarId(Long Tratamiento);
	
	List<Tratamiento> listar();
}
