package com.blimop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blimop.model.Paciente;

public interface IPacienteDAO extends JpaRepository<Paciente, Long> {

}
