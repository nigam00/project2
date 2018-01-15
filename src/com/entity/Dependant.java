package com.entity;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "dependant")
public class Dependant {
	
	@Id
	@Column(name="empid")
	private int id;
	
	@Column(name="relationship")
	private String relation;
	
	@Column(name="gender")
	private String gender;

	@OneToOne(cascade=CascadeType.ALL)
	private Employee emp;
	
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
