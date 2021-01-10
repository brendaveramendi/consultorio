package com.blimop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paciente")


public class Paciente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPaciente;
	
	@Column(name="nombres", nullable=true,length = 70) 
	private String nombres;
	
	@Column(name="dni", nullable=false ,length = 8) 
	private String dni;
	
	
	@Column(name="email", nullable=true,length = 70) 
	private String email;


	public Long getIdPaciente() {
		return idPaciente;
	}


	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
