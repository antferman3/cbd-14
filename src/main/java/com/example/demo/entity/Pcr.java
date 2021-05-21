package com.example.demo.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pcr")
public class Pcr {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;
    
    @Column(name="resultado")
    private String resultado;
    
    @Column(name="fecha_pcr")
    private LocalDate fechaPcr;
    
    @ManyToOne
    @JoinColumn(name = "paciente")
    private Paciente paciente;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaPcr == null) ? 0 : fechaPcr.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
		result = prime * result + ((resultado == null) ? 0 : resultado.hashCode());
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
		Pcr other = (Pcr) obj;
		if (fechaPcr == null) {
			if (other.fechaPcr != null)
				return false;
		} else if (!fechaPcr.equals(other.fechaPcr))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		if (resultado == null) {
			if (other.resultado != null)
				return false;
		} else if (!resultado.equals(other.resultado))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public LocalDate getFechaPcr() {
		return fechaPcr;
	}

	public void setFechaPcr(LocalDate fechaPcr) {
		this.fechaPcr = fechaPcr;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Pcr [id=" + id + ", resultado=" + resultado + ", fechaPcr=" + fechaPcr + ", paciente=" + paciente + "]";
	}

	public Pcr(Integer id, String resultado, LocalDate fechaPcr, Paciente paciente) {
		super();
		this.id = id;
		this.resultado = resultado;
		this.fechaPcr = fechaPcr;
		this.paciente = paciente;
	}

	public Pcr() {
		super();
	}
	
	

    

}
