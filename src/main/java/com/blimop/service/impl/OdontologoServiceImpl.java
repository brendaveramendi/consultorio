package com.blimop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blimop.dao.IOdontologoDAO;
import com.blimop.model.Odontologo;
import com.blimop.service.IOdontologoService;

public class OdontologoServiceImpl implements IOdontologoService {
	
	@Autowired
	private IOdontologoDAO dao;

	@Override
	public Odontologo registrar(Odontologo odontologo) {
		return dao.save(odontologo);
		
	}

	@Override
	public void modificar(Odontologo odontologo) {
		dao.save(odontologo);
		
	}

	@Override
	public void eliminar(Long id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Odontologo> listar() {
		
		return dao.findAll();
		
		
	}

	@Override
	public Odontologo listarId (Long id) {
		
		return dao.getOne(id);
	}

}
