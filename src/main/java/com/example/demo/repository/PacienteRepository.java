package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.example.demo.entity.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente,Integer>{
	@Query("SELECT DISTINCT paciente.ciudad from Paciente paciente")
	List<String> getCiudades();
	
	@Query("SELECT DISTINCT paciente.provincia from Paciente paciente")
	List<String> getProvincias();
}
