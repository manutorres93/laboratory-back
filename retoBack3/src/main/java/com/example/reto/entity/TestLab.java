/**
 * 
 */
package com.example.reto.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table (name= "test")

public class TestLab {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "idTest")
	private int idTest;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "description")
	private String description;

	public TestLab() {
		super();
	}

	public TestLab(int idTest, String name, String description) {
		super();
		this.idTest = idTest;
		this.name = name;
		this.description = description;
	}

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
	
	
	

}