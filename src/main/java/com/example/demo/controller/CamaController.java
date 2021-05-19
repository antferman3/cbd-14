package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Cama;
import com.example.demo.repository.CamaRepository;
import com.example.demo.repository.PcrRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="onlinestore", description="Encuentra aquí toda la información sobre las camas") 
public class CamaController {
	
	@Autowired
	private CamaRepository camaRepository;
	
	@Autowired
	private PcrRepository pcrRepository;
	
	@ApiOperation(value = "Listar todas las camas")
	@GetMapping(path="/camas")
	public @ResponseBody Iterable<Cama> getAllBed(){
		return camaRepository.findAll();
	}
	
	@ApiOperation(value = "Ocupación de los hospitales")
	@GetMapping(path="camas/ocupacion/{hospital}")
	public @ResponseBody Double getOcupacionDeLosHospitales(@PathVariable("hospital")String hospital) {
		return camaRepository.getOcupacionDeLosHospitales(hospital);
	}
	
	@ApiOperation(value = "Número de pacientes en UCI que son positivos")
	@GetMapping(path="/positivos/uci")
	public @ResponseBody Integer getPositivosEnUci() {
		return pcrRepository.getPositivosEnUci();
	}
	
	@ApiOperation(value = "Número de pacientes en planta que son positivos")
	@GetMapping(path="/positivos/planta")
	public @ResponseBody Integer getPositivosEnPlanta() {
		return pcrRepository.getPositivosEnPlanta();
	}
	
	@ApiOperation(value = "Listado de hospitales")
	@GetMapping(path="/hospitales")
	public @ResponseBody List<String> getHospitales() {
		return camaRepository.getHospitales();
	}
}
