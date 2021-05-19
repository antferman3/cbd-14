package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Paciente;
import com.example.demo.repository.PacienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="onlinestore", description="Encuentra aquí toda la información sobre los pacientes") 
public class PacienteController {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
//	@RequestMapping(path = "/")
//    public String index() {
//
//        return "index";
//    }
//	
	@ApiOperation(value = "Listar todos los pacientes")
	@GetMapping(path="/pacientes",produces = "application/json; charset=UTF-8")
	@ResponseBody
	public  List<Paciente> getAllPacientes(){
		return (List<Paciente>) pacienteRepository.findAll();
	}
	
	@ApiOperation(value = "Ciudades de los pacientes")
	@GetMapping(path="/pacientes/ciudades",produces = "application/json; charset=UTF-8")
	@ResponseBody
	public  List<String> getCiudades(){
		return pacienteRepository.getCiudades();
	}
	
	@ApiOperation(value = "Provincias de los pacientes")
	@GetMapping(path="/pacientes/provincias",produces = "application/json; charset=UTF-8")
	@ResponseBody
	public  List<String> getProvinicas(){
		return pacienteRepository.getProvincias();
	}

}
