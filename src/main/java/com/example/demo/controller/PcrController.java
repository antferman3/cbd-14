package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

}
