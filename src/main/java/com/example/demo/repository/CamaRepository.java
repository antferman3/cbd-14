package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Cama;

public interface CamaRepository extends CrudRepository<Cama,Integer>{
	
	//Probar bien
//	@Query("SELECT SUM(cama.hospital =?1 AND cama.fecha_ingreso IS NOT NULL)/COUNT(*) FROM Cama cama WHERE cama.hospital =?1")
//	Integer getOcupacionDeLosHospitales(@Param("hospital") String hospital);

}
