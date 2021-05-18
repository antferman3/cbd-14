package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Paciente;
import com.example.demo.entity.Pcr;

@Repository
public interface PcrRepository extends CrudRepository<Pcr,Integer>{
	
	@Query("SELECT count(paciente) from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO'")
	Integer getNumeroDePositivos();
//	
	@Query("SELECT distinct count(paciente) from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO' GROUP BY pcr.paciente HAVING COUNT(*) > 1")
	Integer getNumeroDeReinfectados();
	
	@Query("SELECT paciente from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO' GROUP BY pcr.paciente HAVING COUNT(*) > 1")
	List<Paciente> getPacientesReinfectados();
//	
	@Query("SELECT count(paciente) from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO' where paciente.ciudad =?1")
	Integer getNumeroDePositivosPorCiudad(@Param ("ciudad") String ciudad);
	
	@Query("SELECT count(paciente) from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO' where paciente.provincia =?1")
	Integer getNumeroDePositivosPorProvincia(@Param ("provincia") String provincia);
	
	@Query("SELECT count(paciente) from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO' where paciente.paisOrigen != 'ES'")
	Integer getNumeroDePositivosExtranjeros();
	
	@Query("SELECT count(paciente) from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO' where paciente.paisOrigen != 'ES' AND paciente.ciudad =?1")
	Integer getNumeroDePositivosExtranjerosPorCiudad(@Param ("ciudad") String ciudad);
	
	@Query("SELECT fechaPcr, count(*) from Pcr pcr GROUP BY pcr.fechaPcr")
	Object[] getPcrsPoDia();
	
	@Query("SELECT avg(paciente.peso) from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO'")
	Double getPesoMedioDeLosPositivos();
	
	@Query("SELECT avg(paciente.edad) from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO'")
	Double getEdadMediaDeLosPositivos();
	
	@Query("SELECT paciente.patologias from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO'")
	List<String> getPatologiasDeLosPositivos();
	
	@Query ("SELECT count(*) from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO' WHERE paciente.cama IS NOT NULL")
	Integer getPositivosQueNecesitaronIngreso();
	
	@Query ("SELECT count(*) from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO' INNER JOIN Cama cama ON cama.id = paciente.cama AND cama.estado ='UCI' WHERE paciente.cama IS NOT NULL")
	Integer getPositivosEnUci();
	
	@Query ("SELECT count(*) from Paciente paciente INNER JOIN Pcr pcr ON pcr.paciente = paciente.id  AND pcr.resultado ='POSITIVO' INNER JOIN Cama cama ON cama.id = paciente.cama AND cama.estado ='Planta' WHERE paciente.cama IS NOT NULL")
	Integer getPositivosEnPlanta();


}
