package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;

    @Column(name="edad")
    private Integer edad;
    
    @Column(name="peso")
    private Float peso;
    
    @Column(name="ciudad")
    private String ciudad;
    
    @Column(name="provincia")
    private String provincia;
    
    @Column(name="comunidad")
    private String comunidad;
    
    @Column(name="pais_origen")
    private String paisOrigen;
    
    @Column(name="patologias")
    private String patologias;
    
    @Column(name="genero")
    private String genero;
    
    @Column(name="dni")
    private String dni;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getComunidad() {
		return comunidad;
	}

	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public String getPatologias() {
		return patologias;
	}

	public void setPatologias(String patologias) {
		this.patologias = patologias;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((comunidad == null) ? 0 : comunidad.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((edad == null) ? 0 : edad.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((paisOrigen == null) ? 0 : paisOrigen.hashCode());
		result = prime * result + ((patologias == null) ? 0 : patologias.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (comunidad == null) {
			if (other.comunidad != null)
				return false;
		} else if (!comunidad.equals(other.comunidad))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (edad == null) {
			if (other.edad != null)
				return false;
		} else if (!edad.equals(other.edad))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (paisOrigen == null) {
			if (other.paisOrigen != null)
				return false;
		} else if (!paisOrigen.equals(other.paisOrigen))
			return false;
		if (patologias == null) {
			if (other.patologias != null)
				return false;
		} else if (!patologias.equals(other.patologias))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		return true;
	}
	
	public Paciente() {
		super();
	}
    

	public Paciente(Integer id, Integer edad, Float peso, String ciudad, String provincia, String comunidad,
			String paisOrigen, String patologias, String genero, String dni) {
		super();
		this.id = id;
		this.edad = edad;
		this.peso = peso;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.comunidad = comunidad;
		this.paisOrigen = paisOrigen;
		this.patologias = patologias;
		this.genero = genero;
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", dni=" + dni + "]";
	}


    

}
