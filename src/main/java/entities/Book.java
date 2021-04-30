package entities;

import javax.persistence.Column;
import javax.persistence.Id;

public class Book {

	@Id
	@Column
	private Long id;
	
	@Column
	private String name;
	
	public Book() {
		
	}
	
	public Book(String name) {
		this.name=name;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
