package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cama")
public class Vacuna {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;

    @OneToOne
    private Paciente pacienteVacunaId;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="dosis")
    private Integer dosis;
    
    @Column(name="fecha_vacunacion")
    private Date fechaVacunacion;
    
    @Column(name="ciudad_vacuna")
    private String ciudadVacuna;


    
    

}
