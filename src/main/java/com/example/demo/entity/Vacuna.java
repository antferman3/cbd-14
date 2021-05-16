package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vacuna")
public class Vacuna {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;

    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="dosis")
    private Integer dosis;
    
    @Column(name="fecha_vacunacion")
    private Date fechaVacunacion;
    
    @Column(name="ciudad_vacuna")
    private String ciudadVacuna;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDosis() {
		return dosis;
	}

	public void setDosis(Integer dosis) {
		this.dosis = dosis;
	}

	public Date getFechaVacunacion() {
		return fechaVacunacion;
	}

	public void setFechaVacunacion(Date fechaVacunacion) {
		this.fechaVacunacion = fechaVacunacion;
	}

	public String getCiudadVacuna() {
		return ciudadVacuna;
	}

	public void setCiudadVacuna(String ciudadVacuna) {
		this.ciudadVacuna = ciudadVacuna;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciudadVacuna == null) ? 0 : ciudadVacuna.hashCode());
		result = prime * result + ((dosis == null) ? 0 : dosis.hashCode());
		result = prime * result + ((fechaVacunacion == null) ? 0 : fechaVacunacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Vacuna other = (Vacuna) obj;
		if (ciudadVacuna == null) {
			if (other.ciudadVacuna != null)
				return false;
		} else if (!ciudadVacuna.equals(other.ciudadVacuna))
			return false;
		if (dosis == null) {
			if (other.dosis != null)
				return false;
		} else if (!dosis.equals(other.dosis))
			return false;
		if (fechaVacunacion == null) {
			if (other.fechaVacunacion != null)
				return false;
		} else if (!fechaVacunacion.equals(other.fechaVacunacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public Vacuna() {
		super();
	}

	public Vacuna(Integer id, String nombre, Integer dosis, Date fechaVacunacion,
			String ciudadVacuna) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dosis = dosis;
		this.fechaVacunacion = fechaVacunacion;
		this.ciudadVacuna = ciudadVacuna;
	}

	@Override
	public String toString() {
		return "Vacuna [id=" + id + "]";
	}


    
    

}
