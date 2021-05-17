package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Paciente;
import com.example.demo.entity.Vacuna;

public interface VacunaRepository extends CrudRepository<Vacuna,Integer>{
	
//	@Query("SELECT avg(edad) from Paciente paciente INNER JOIN Vacuna vacuna ON vacuna.id = paciente.vacuna")
//	Double getEdadMediaDeLosVacunados();
//	
//	@Query("SELECT avg(peso) from Paciente paciente INNER JOIN Vacuna vacuna ON vacuna.id = paciente.vacuna")
//	Double getPesoMedioDeLosVacunados();
//	
//	@Query("SELECT count(paciente) from Paciente paciente INNER JOIN Vacuna vacuna ON vacuna.id = paciente.vacuna INNER JOIN Pcr pcr ON pcr.paciente = paciente.id AND pcr.resultado = 'POSITIVO'")
//	Integer getPositivosVacunados();
//	
//	@Query("SELECT paciente from Paciente paciente INNER JOIN Vacuna vacuna ON vacuna.id = paciente.vacuna WHERE paciente.edad =?1")
//	List<Paciente> getPacientesVacunadosPorEdad(@Param ("edad") String edad);
//	
//	@Query("SELECT paciente from Paciente paciente INNER JOIN Vacuna vacuna ON vacuna.id = paciente.vacuna WHERE paciente.ciudad =?1")
//	List<Paciente> getPacientesVacunadosPorCiudad(@Param ("ciudad") String ciudad);

}
