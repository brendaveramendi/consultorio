package com.blimop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="odontologo")
public class Odontologo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOdontologo;
	
	@Column(name="nombres", nullable=false,length = 70) 
	private String nombres;
	
	@Column(name="matricula", nullable=false ,length = 12) 
	private String matricula;

	public long getIdOdontologo() {
		return idOdontologo;
	}

	public void setIdOdontologo(Long idOdontologo) {
		this.idOdontologo = idOdontologo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
	
}
