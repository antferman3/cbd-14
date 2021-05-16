package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Paciente;
import com.example.demo.repository.PacienteRepository;

@Controller
public class PacienteController {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@RequestMapping(path = "/a")
    public String index() {

        return "index.html";
    }
	@GetMapping(path="/pacientes",produces = "application/json; charset=UTF-8")
	@ResponseBody
	public  List<Paciente> getAllPacientes(){
		return (List<Paciente>) pacienteRepository.findAll();
	}

}
