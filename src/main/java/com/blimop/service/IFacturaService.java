package com.blimop.service;

import java.util.List;

import com.blimop.model.Factura;

public interface IFacturaService {

Factura registrar (Factura factura);
	
	void modificar (Factura factura);
	
	void eliminar(Long idFactura);
	
	Factura listarId(Long idFactura);
	
	List<Factura> listar();
}
