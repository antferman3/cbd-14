package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente,Integer>{
	@Query("SELECT DISTINCT paciente.ciudad from Paciente paciente")
	List<String> getCiudades();
	
	@Query("SELECT DISTINCT paciente.provincia from Paciente paciente")
	List<String> getProvincias();
	
	@Query("SELECT paciente FROM Paciente paciente WHERE paciente.vacuna.id = ?1")
	List<Paciente> findPacienteByVacuna(@Param("vacunaId") int vacuna);
	
	@Query("SELECT paciente FROM Paciente paciente WHERE paciente.cama.id = ?1")
	List<Paciente> findPacienteByCama(@Param("camaId") int cama);
}
