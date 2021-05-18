package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Paciente;
import com.example.demo.entity.Pcr;
import com.example.demo.entity.Vacuna;
import com.example.demo.repository.VacunaRepository;

@Controller
public class VacunaController {
	
	@Autowired
	private VacunaRepository vacunaRepository;
	
	
	@GetMapping(path="/vacunas")
	public @ResponseBody Iterable<Vacuna> getAllVacunas(){
		return vacunaRepository.findAll();
	}
	
	@PostMapping(path="/vacunas/update/{vacunaId}")
	@ResponseBody 
    public Vacuna updateVacuna (@PathVariable("vacunaId") int vacunaId) {
		Vacuna vacuna = vacunaRepository.findById(vacunaId).get();
		vacuna.setDosis(vacuna.getDosis()+1);
		vacunaRepository.save(vacuna);
		return vacuna;
    }
	
	@PostMapping(path="/anadir/vacuna") 
    public @ResponseBody String addNewPCR(@Valid Pcr pcr, @RequestParam String name,BindingResult result) {
        return "Saved";
    }
	
	@GetMapping(path="/vacunados/edadmedia")
	public @ResponseBody Double getEdadMediaDeLosPositivos(){
		return vacunaRepository.getEdadMediaDeLosVacunados();
	}
	
	@GetMapping(path="/vacunados/pesomedio")
	public @ResponseBody Double getPesoMedioDeLosPositivos(){
		return vacunaRepository.getPesoMedioDeLosVacunados();
	}
	
	@GetMapping(path="/vacunados/positivos")
	public @ResponseBody Integer getNumeroDeVacunadosPositivos(){
		return vacunaRepository.getPositivosVacunados();
	}
	
	@GetMapping(path="vacunados/edad/{edad}")
	public @ResponseBody List<Paciente> getVacunadosPorEdad(@PathVariable("edad")Integer edad) {
		return vacunaRepository.getPacientesVacunadosPorEdad(edad);
	}
	
	@GetMapping(path="vacunados/ciudad/{ciudad}")
	public @ResponseBody List<Paciente> getVacunadosPorEdad(@PathVariable("ciudad")String ciudad) {
		return vacunaRepository.getPacientesVacunadosPorCiudad(ciudad);
	}

}
