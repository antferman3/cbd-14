package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Pcr;

@Repository
public interface PcrRepository extends CrudRepository<Pcr,Integer>{
	
	@Query("SELECT count(paciente) from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO' where paciente.ciudad =?1")
	Integer getNumeroDePositivosPorCiudad(@Param ("ciudad") String ciudad);
	
	@Query("SELECT count(paciente) from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO' where paciente.provincia =?1")
	Integer getNumeroDePositivosPorProvincia(@Param ("provincia") String provincia);
	
	@Query("SELECT count(paciente) from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO' where paciente.paisOrigen != 'ES'")
	Integer getNumeroDePositivosExtranjeros();
	
	@Query("SELECT count(paciente) from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO' where paciente.paisOrigen != 'ES' AND paciente.ciudad =?1")
	Integer getNumeroDePositivosExtranjerosPorCiudad(@Param ("ciudad") String ciudad);


}
