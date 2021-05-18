package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Paciente;
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
	
	@GetMapping(path="positivos")
	public @ResponseBody Integer getNumeroDePositivos() {
		return pcrRepository.getNumeroDePositivos();
	}
	@GetMapping(path="reinfectados")
	public @ResponseBody Integer getNumeroReinfectados() {
		return pcrRepository.getNumeroDeReinfectados();
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
	
	@GetMapping(path="/reinfectados/pacientes")
	public @ResponseBody List<Paciente> getPacientesReinfectados(){
		return pcrRepository.getPacientesReinfectados();
	}
	
	@GetMapping(path="/pcr/numerodiario")
	public @ResponseBody Object[] getPcrPorDia(){
		return pcrRepository.getPcrsPoDia();
	}
	
	@GetMapping(path="/positivos/pesomedio")
	public @ResponseBody Double getPesoMedioDeLosPositivos(){
		return pcrRepository.getPesoMedioDeLosPositivos();
	}
	
	@GetMapping(path="/positivos/edadmedia")
	public @ResponseBody Double getEdadMediaDeLosPositivos(){
		return pcrRepository.getEdadMediaDeLosPositivos();
	}
	
	@GetMapping(path="/positivos/patologias")
	public @ResponseBody List<String> getPatologiasPositivos(){
		return pcrRepository.getPatologiasDeLosPositivos();
	}
	
	@GetMapping(path="/positivos/ingreso")
	public @ResponseBody Integer getPositivosQueNecesitaronIngreso() {
		return pcrRepository.getPositivosQueNecesitaronIngreso();
	}
	
	@GetMapping(path="/positivos/uci")
	public @ResponseBody Integer getPositivosEnUci() {
		return pcrRepository.getPositivosEnUci();
	}
	
	@GetMapping(path="/positivos/planta")
	public @ResponseBody Integer getPositivosEnPlanta() {
		return pcrRepository.getPositivosEnPlanta();
	}
	

}
