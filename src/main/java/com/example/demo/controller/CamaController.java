package com.example.demo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Cama;
import com.example.demo.repository.CamaRepository;

@Controller
public class CamaController {
	
	@Autowired
	private CamaRepository camaRepository;
	
	
	@GetMapping(path="/camas")
	public @ResponseBody Iterable<Cama> listBed(){
		return camaRepository.findAll();
	}
	
	@GetMapping(path="camas/ocupacion/{hospital}")
	public @ResponseBody Double getPositivosPorCiudad(@PathVariable("hospital")String hospital) {
		return camaRepository.getOcupacionDeLosHospitales(hospital);
	}

}
