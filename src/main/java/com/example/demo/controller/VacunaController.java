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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="onlinestore", description="Encuentra aquí toda la información sobre las vacunas") 
public class VacunaController {
	
	@Autowired
	private VacunaRepository vacunaRepository;
	
	@ApiOperation(value = "Listar todas las vacunas")
	@GetMapping(path="/vacunas")
	public @ResponseBody Iterable<Vacuna> getAllVacunas(){
		return vacunaRepository.findAll();
	}
	
	//CAMBIAR VACUNA POR PACIENTE
	@ApiOperation(value = "Actualizar dosis de la vacunación administrada al paciente")
	@PostMapping(path="/vacunas/update/{vacunaId}")
	@ResponseBody 
    public Vacuna updateVacuna (@PathVariable("vacunaId") int vacunaId) {
		Vacuna vacuna = vacunaRepository.findById(vacunaId).get();
		vacuna.setDosis(vacuna.getDosis()+1);
		vacunaRepository.save(vacuna);
		return vacuna;
    }
	
	@ApiOperation(value = "Crear vacuna")
	@PostMapping(path="/anadir/vacuna") 
    public @ResponseBody String addNewPCR(@Valid Pcr pcr, @RequestParam String name,BindingResult result) {
        return "Saved";
    }
	
	@ApiOperation(value = "Edad media de los vacunados")
	@GetMapping(path="/vacunados/edadmedia")
	public @ResponseBody Double getEdadMediaDeLosPositivos(){
		return vacunaRepository.getEdadMediaDeLosVacunados();
	}
	
	@ApiOperation(value = "Peso medio de los vacunados")
	@GetMapping(path="/vacunados/pesomedio")
	public @ResponseBody Double getPesoMedioDeLosPositivos(){
		return vacunaRepository.getPesoMedioDeLosVacunados();
	}
	
	@ApiOperation(value = "Número de pacientes que han sido positivo y posteriormente vacunados")
	@GetMapping(path="/vacunados/positivos")
	public @ResponseBody Integer getPositivosVacunados(){
		return vacunaRepository.getPositivosVacunados();
	}
	
	@ApiOperation(value = "Número de pacientes que han sido positivo y posteriormente vacunados")
	@GetMapping(path="vacunados/edad/{edad}")
	public @ResponseBody List<Paciente> getVacunadosPorEdad(@PathVariable("edad")Integer edad) {
		return vacunaRepository.getPacientesVacunadosPorEdad(edad);
	}
	
	@ApiOperation(value = "Lista de los vacunados en función de la ciudad")
	@GetMapping(path="vacunados/ciudad/{ciudad}")
	public @ResponseBody List<Paciente> getVacunadosPorCiudad(@PathVariable("ciudad")String ciudad) {
		return vacunaRepository.getPacientesVacunadosPorCiudad(ciudad);
	}

}
