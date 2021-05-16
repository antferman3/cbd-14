package com.example.demo.controller;

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
	
//	@PostMapping(path="/add") // Map ONLY POST Requests
//    public @ResponseBody String addNewUser (@RequestParam String name) {
//      // @ResponseBody means the returned String is the response, not a view name
//      // @RequestParam means it is a parameter from the GET or POST request
//      return "Saved";
//    }
	
	@GetMapping(path="/pacientes")
	public @ResponseBody Iterable<Paciente> getAllPacientes(){
		return pacienteRepository.findAll();
	}

}
