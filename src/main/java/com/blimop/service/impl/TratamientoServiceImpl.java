package com.blimop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blimop.dao.ITratamientoDAO;
import com.blimop.model.Tratamiento;
import com.blimop.service.ITratamientoService;





public class TratamientoServiceImpl implements ITratamientoService{
	
	@Autowired
	private ITratamientoDAO dao;

	@Override
	public Tratamiento registrar(Tratamiento tratamiento) {
		return dao.save(tratamiento);
		
	}

	@Override
	public void modificar(Tratamiento tratamiento) {
		dao.save(tratamiento);
		
	}

	@Override
	public void eliminar(Long id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Tratamiento> listar() {
		
		return dao.findAll();
		
		
	}

	@Override
	public Tratamiento listarId (Long id) {
		
		return dao.getOne(id);
	}
	
	


}
