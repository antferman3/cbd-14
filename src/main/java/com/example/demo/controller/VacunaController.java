package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Cama;
import com.example.demo.entity.Paciente;
import com.example.demo.entity.Pcr;
import com.example.demo.entity.Vacuna;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.repository.VacunaRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="onlinestore", description="Encuentra aquí toda la información sobre las vacunas") 
public class VacunaController {
	
	@Autowired
	private VacunaRepository vacunaRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	
	@ApiOperation(value = "Listar todas las vacunas")
	@GetMapping(path="/vacunas")
	public @ResponseBody Iterable<Vacuna> getAllVacunas(){
		return vacunaRepository.findAll();
	}
	
	
	@ApiOperation(value = "Actualizar dosis de la vacunación administrada al paciente")
	@PutMapping(path="/vacunas/update/{pacienteId}")
	@ResponseBody 
    public Vacuna updateVacuna (@PathVariable("pacienteId") int pacienteId) {
		Paciente paciente = pacienteRepository.findById(pacienteId).get();
		Vacuna vacuna = paciente.getVacuna();
		vacuna.setDosis(vacuna.getDosis()+1);
		vacunaRepository.save(vacuna);
		return vacuna;
    }
	
	@ApiOperation(value = "Eliminar vacuna")
	@DeleteMapping(path="/vacunas/delete/{vacunaId}")
	@ResponseBody 
    public Vacuna deleteVacuna (@PathVariable("vacunaId") int vacunaId) {
		Vacuna vacuna = vacunaRepository.findById(vacunaId).get();
		
		List<Paciente> paciente = pacienteRepository.findPacienteByVacuna(vacunaId);
		if (paciente.size()>(0)) {
			paciente.get(0).setVacuna(null);
			pacienteRepository.save(paciente.get(0));
		}
		 
		vacunaRepository.delete(vacuna);
		return vacuna;
    }
	
	@ApiOperation(value = "Crear vacuna")
	@PostMapping(path="/vacunas/create")
	@ResponseBody 
    public Vacuna createVacuna (@RequestBody String body) {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Vacuna vacuna = new Vacuna();
            JsonNode jsonNode = objectMapper.readTree(body);

            String nombre = objectMapper.readTree(jsonNode.get("nombre").toString()).asText();
            Integer dosis = objectMapper.readTree(jsonNode.get("dosis").toString()).asInt();
            LocalDate fecha = LocalDate.parse((objectMapper.readTree(jsonNode.get("fecha").toString()).asText()), dtf);
            String ciudad = objectMapper.readTree(jsonNode.get("ciudad_vacuna").toString()).asText();

            vacuna.setNombre(nombre);
            vacuna.setDosis(dosis);
            vacuna.setFechaVacunacion(fecha);
            vacuna.setCiudadVacuna(ciudad);
            

            vacunaRepository.save(vacuna);
            return vacuna;
        } catch (Exception e) {
            throw (new IllegalArgumentException(e.getMessage()));
        }

    }
	
	
	@ApiOperation(value = "Edad media de los vacunados")
	@GetMapping(path="/vacunados/edadmedia")
	public @ResponseBody Double getEdadMediaDeLosVacunados(){
		return vacunaRepository.getEdadMediaDeLosVacunados();
	}
	
	@ApiOperation(value = "Peso medio de los vacunados")
	@GetMapping(path="/vacunados/pesomedio")
	public @ResponseBody Double getPesoMedioDeLosVacunados(){
		return vacunaRepository.getPesoMedioDeLosVacunados();
	}
	
	@ApiOperation(value = "Número de pacientes que han sido positivo y posteriormente vacunados")
	@GetMapping(path="/vacunados/positivos")
	public @ResponseBody Integer getPositivosVacunados(){
		return vacunaRepository.getPositivosVacunados();
	}
	
	@ApiOperation(value = "Listado de pacientes vacunados según la edad")
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
