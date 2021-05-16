package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	public @ResponseBody Iterable<Cama> getAllCamas(){
		return camaRepository.findAll();
	}

}
