package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Pcr;
import com.example.demo.repository.PcrRepository;

@Controller
public class PcrController {
	
	@Autowired
	private PcrRepository pcrRepository;
	
	
	@GetMapping(path="/pcr")
	public @ResponseBody Iterable<Pcr> getAllPcr(){
		return pcrRepository.findAll();
	}
	
	@GetMapping(path="positivos/ciudad/{ciudad}")
	public @ResponseBody Integer getPositivosPorCiudad(@PathVariable("ciudad")String ciudad) {
		return pcrRepository.getNumeroDePositivosPorCiudad(ciudad);
	}
	
	@GetMapping(path="positivos/provincia/{provincia}")
	public @ResponseBody Integer getPositivosPorProvincia(@PathVariable("provincia")String provincia) {
		return pcrRepository.getNumeroDePositivosPorProvincia(provincia);
	}
	
	@GetMapping(path="positivos/extranjeros")
	public @ResponseBody Integer getPositivosExtranjeros() {
		return pcrRepository.getNumeroDePositivosExtranjeros();
	}
	
	@GetMapping(path="positivos/extranjeros/{ciudad}")
	public @ResponseBody Integer getPositivosExtranjerosPorCiudad(@PathVariable("ciudad")String ciudad) {
		return pcrRepository.getNumeroDePositivosExtranjerosPorCiudad(ciudad);
	}

}
