package com.blimop.service;

import java.util.List;

import com.blimop.model.Paciente;

public interface IPacienteService {

	Paciente registrar (Paciente paciente);
	
	void modificar (Paciente paciente);
	
	void eliminar(Long idPaciente);
	
	Paciente listarId(Long idPaciente);
	
	List<Paciente> listar();
}
