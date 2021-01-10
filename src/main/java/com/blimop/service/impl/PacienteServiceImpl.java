package com.blimop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blimop.dao.IPacienteDAO;
import com.blimop.model.Paciente;
import com.blimop.service.IPacienteService;

public class PacienteServiceImpl implements IPacienteService {
	
	@Autowired
	private IPacienteDAO dao;

	@Override
	public Paciente registrar(Paciente paciente) {
		return dao.save(paciente);
		
	}

	@Override
	public void modificar(Paciente paciente) {
		dao.save(paciente);
		
	}

	@Override
	public void eliminar(Long id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Paciente> listar() {
		
		return dao.findAll();
		
		
	}

	@Override
	public Paciente listarId (Long id) {
		
		return dao.getOne(id);
	}
	
	

}
