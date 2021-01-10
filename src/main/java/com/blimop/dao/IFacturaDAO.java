package com.blimop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blimop.model.Factura;

public interface IFacturaDAO extends JpaRepository<Factura, Long>{

}
