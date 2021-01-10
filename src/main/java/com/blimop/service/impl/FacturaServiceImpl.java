package com.blimop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blimop.dao.IFacturaDAO;
import com.blimop.model.Factura;
import com.blimop.service.IFacturaService;


public class FacturaServiceImpl implements IFacturaService {
	@Autowired
	private IFacturaDAO dao;

	@Override
	public Factura registrar(Factura Factura) {
		return dao.save(Factura);
		
	}

	@Override
	public void modificar(Factura factura) {
		dao.save(factura);
		
	}

	@Override
	public void eliminar(Long id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Factura> listar() {
		
		return dao.findAll();
		
		
	}

	@Override
	public Factura listarId (Long id) {
		
		return dao.getOne(id);
	}
	
	


}
