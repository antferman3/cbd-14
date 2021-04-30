package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;

    @Column
    private String name;

    public Book() {

    }

    public Book(String name) {
        this.name=name;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
