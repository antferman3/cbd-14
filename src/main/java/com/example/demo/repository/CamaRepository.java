package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Cama;

public interface CamaRepository extends CrudRepository<Cama,Integer>{
	
	//Funciona pero solo me devuelve 1 decimal me cago en su puta madre la coja
	@Query("SELECT (SELECT count(cama) From Cama cama WHERE cama.hospital= ?1 AND cama.fechaIngreso IS NOT NULL)/ count(c) From Cama c where c.hospital =?1")
	Double getOcupacionDeLosHospitales(@Param("hospital") String hospital);
	
	@Query("SELECT DISTINCT cama.hospital from Cama cama")
	List<String> getHospitales();

}
