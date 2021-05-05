package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="pcr")
public class Pcr {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;
    
    @ManyToOne
    public Paciente pacientePcrId;
    
    @Column(name="resultado")
    private String resultado;
    
    @Column(name="fecha_pcr")
    private Date fechaPcr;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Paciente getPacientePcrId() {
		return pacientePcrId;
	}

	public void setPacientePcrId(Paciente pacientePcrId) {
		this.pacientePcrId = pacientePcrId;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Date getFechaPcr() {
		return fechaPcr;
	}

	public void setFechaPcr(Date fechaPcr) {
		this.fechaPcr = fechaPcr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaPcr == null) ? 0 : fechaPcr.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pacientePcrId == null) ? 0 : pacientePcrId.hashCode());
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
		if (pacientePcrId == null) {
			if (other.pacientePcrId != null)
				return false;
		} else if (!pacientePcrId.equals(other.pacientePcrId))
			return false;
		if (resultado == null) {
			if (other.resultado != null)
				return false;
		} else if (!resultado.equals(other.resultado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pcr [id=" + id + ", pacientePcrId=" + pacientePcrId + "]";
	}

	public Pcr() {
		super();
	}

	public Pcr(Integer id, Paciente pacientePcrId, String resultado, Date fechaPcr) {
		super();
		this.id = id;
		this.pacientePcrId = pacientePcrId;
		this.resultado = resultado;
		this.fechaPcr = fechaPcr;
	}

	

    

}
