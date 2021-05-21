package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Cama;
import com.example.demo.entity.Paciente;
import com.example.demo.repository.CamaRepository;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.repository.PcrRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="onlinestore", description="Encuentra aquí toda la información sobre las camas") 
public class CamaController {
	
	@Autowired
	private CamaRepository camaRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private PcrRepository pcrRepository;
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	@ApiOperation(value = "Crear cama")
	@PostMapping(path="/camas/create")
	@ResponseBody 
    public Cama createCama (@RequestBody String body) {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Cama cama = new Cama();
            JsonNode jsonNode = objectMapper.readTree(body);

            LocalDate fechaIngreso = jsonNode.get("fecha_ingreso").isNull()?null:LocalDate.parse((objectMapper.readTree(jsonNode.get("fecha_ingreso").toString()).asText()), dtf);
            LocalDate fechaAlta = jsonNode.get("fecha_alta").isNull()?null:LocalDate.parse((objectMapper.readTree(jsonNode.get("fecha_alta").toString()).asText()), dtf);
            String estado = jsonNode.get("estado").isNull()?null:objectMapper.readTree(jsonNode.get("estado").toString()).asText();
            String hospital = objectMapper.readTree(jsonNode.get("hospital").toString()).asText();
       

            cama.setFechaIngreso(fechaIngreso);
            cama.setFechaAlta(fechaAlta);
            cama.setHospital(hospital);
            cama.setEstado(estado);
            

            camaRepository.save(cama);
            return cama;
            
        } catch (Exception e) {
            throw (new IllegalArgumentException(e.getMessage()));
        }

    }
	
	@ApiOperation(value = "Eliminar cama")
	@DeleteMapping(path="/camas/delete/{camaId}")
	@ResponseBody 
    public Cama deleteCama (@PathVariable("camaId") int camaId) {
		Cama cama = camaRepository.findById(camaId).get();
		System.out.println(cama);
		
		List<Paciente> paciente = pacienteRepository.findPacienteByCama(camaId);
		if (paciente.size()>(0)) {
			paciente.get(0).setCama(null);
			pacienteRepository.save(paciente.get(0));
		}
		 
		camaRepository.delete(cama);
		return cama;
    }
	
	@ApiOperation(value = "Listar todas las camas")
	@GetMapping(path="/camas")
	public @ResponseBody Iterable<Cama> getAllBed(){
		return camaRepository.findAll();
	}
	
	@ApiOperation(value = "Ocupación de los hospitales")
	@GetMapping(path="camas/ocupacion/{hospital}")
	public @ResponseBody Double getOcupacionDeLosHospitales(@PathVariable("hospital")String hospital) {
		return camaRepository.getOcupacionDeLosHospitales(hospital);
	}
	
	
	@ApiOperation(value = "Número de pacientes en UCI que son positivos")
	@GetMapping(path="/positivos/uci")
	public @ResponseBody Integer getPositivosEnUci() {
		return pcrRepository.getPositivosEnUci();
	}
	
	@ApiOperation(value = "Número de pacientes en planta que son positivos")
	@GetMapping(path="/positivos/planta")
	public @ResponseBody Integer getPositivosEnPlanta() {
		return pcrRepository.getPositivosEnPlanta();
	}
	
	@ApiOperation(value = "Listado de hospitales")
	@GetMapping(path="/hospitales")
	public @ResponseBody List<String> getHospitales() {
		return camaRepository.getHospitales();
	}
}
