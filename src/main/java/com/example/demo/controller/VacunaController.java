package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
