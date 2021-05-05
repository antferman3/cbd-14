package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.entity.Paciente;

public interface BookRepository extends CrudRepository<Paciente,Long>{

}
