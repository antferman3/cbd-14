package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Paciente;
import com.example.demo.entity.Pcr;
import com.example.demo.entity.Vacuna;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.repository.PcrRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="onlinestore", description="Encuentra aquí toda la información sobre las pcr") 
public class PcrController {
	
	@Autowired
	private PcrRepository pcrRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	@ApiOperation(value = "Crear pcr")
	@PostMapping(path="/pcr/create")
	@ResponseBody 
    public Pcr createPcr (@RequestBody String body) {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Pcr pcr = new Pcr();
            JsonNode jsonNode = objectMapper.readTree(body);

            String resultado = objectMapper.readTree(jsonNode.get("resultado").toString()).asText();
            LocalDate fecha = LocalDate.parse((objectMapper.readTree(jsonNode.get("fecha").toString()).asText()), dtf);
            Integer pacienteId	 = objectMapper.readTree(jsonNode.get("paciente").toString()).asInt();
            
            Paciente paciente = pacienteRepository.findById(pacienteId).get();

            pcr.setFechaPcr(fecha);
            pcr.setPaciente(paciente);
            pcr.setResultado(resultado);
            

            pcrRepository.save(pcr);
            return pcr;
        } catch (Exception e) {
            throw (new IllegalArgumentException(e.getMessage()));
        }

    }
	
	@ApiOperation(value = "Listar todas la pcr realizadas")
	@GetMapping(path="/pcr")
	public @ResponseBody Iterable<Pcr> getAllPcr(){
		return pcrRepository.findAll();
	}
	@ApiOperation(value = "Número de positivos en la pcr")
	@GetMapping(path="positivos")
	public @ResponseBody Integer getNumeroDePositivos() {
		return pcrRepository.getNumeroDePositivos();
	}
	@ApiOperation(value = "Número de personas que se han reinfectado")
	@GetMapping(path="reinfectados")
	public @ResponseBody Integer getNumeroReinfectados() {
		return pcrRepository.getPacientesReinfectados().size();
	}
	
	@ApiOperation(value = "Número de positivos en función de la ciudad")
	@GetMapping(path="positivos/ciudad/{ciudad}")
	public @ResponseBody Integer getPositivosPorCiudad(@PathVariable("ciudad")String ciudad) {
		return pcrRepository.getNumeroDePositivosPorCiudad(ciudad);
	}
	@ApiOperation(value = "Número de positivos en función de la provincia")
	@GetMapping(path="positivos/provincia/{provincia}")
	public @ResponseBody Integer getPositivosPorProvincia(@PathVariable("provincia")String provincia) {
		return pcrRepository.getNumeroDePositivosPorProvincia(provincia);
	}
	@ApiOperation(value = "Número de positivos que son extranjeros")
	@GetMapping(path="positivos/extranjeros")
	public @ResponseBody Integer getPositivosExtranjeros() {
		return pcrRepository.getNumeroDePositivosExtranjeros();
	}
	
	@ApiOperation(value = "Número de positivos que son extranjeros en función de una ciudad")
	@GetMapping(path="positivos/extranjeros/{ciudad}")
	public @ResponseBody Integer getPositivosExtranjerosPorCiudad(@PathVariable("ciudad")String ciudad) {
		return pcrRepository.getNumeroDePositivosExtranjerosPorCiudad(ciudad);
	}
	
	@ApiOperation(value = "Listado de pacientes que se han reinfectado por COVID")
	@GetMapping(path="/reinfectados/pacientes")
	public @ResponseBody List<Paciente> getPacientesReinfectados(){
		return pcrRepository.getPacientesReinfectados();
	}
	
	@ApiOperation(value = "Número de pcr realizadas por día")
	@GetMapping(path="/pcr/numerodiario")
	public @ResponseBody Object[] getPcrPorDia(){
		return pcrRepository.getPcrsPoDia();
	}
	
	@ApiOperation(value = "Peso promedio de los positivos")
	@GetMapping(path="/positivos/pesomedio")
	public @ResponseBody Double getPesoMedioDeLosPositivos(){
		return pcrRepository.getPesoMedioDeLosPositivos();
	}
	
	@ApiOperation(value = "Edad media de los positivos")
	@GetMapping(path="/positivos/edadmedia")
	public @ResponseBody Double getEdadMediaDeLosPositivos(){
		return pcrRepository.getEdadMediaDeLosPositivos();
	}
	
	@ApiOperation(value = "Lista con las patologíoas de los positivos")
	@GetMapping(path="/positivos/patologias")
	public @ResponseBody List<String> getPatologiasPositivos(){
		return pcrRepository.getPatologiasDeLosPositivos();
	}
	
	@ApiOperation(value = "Número de positivos que necesitaron ser ingresados")
	@GetMapping(path="/positivos/ingreso")
	public @ResponseBody Integer getPositivosQueNecesitaronIngreso() {
		return pcrRepository.getPositivosQueNecesitaronIngreso();
	}

	

	

}
