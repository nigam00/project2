package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstname;

	@Column(name = "last_name")
	private String lastname;

	@Column(name = "email")
	private String email;


	public Manager getManage() {
		return manage;
	}

	public Employee(int id) {
	super();
	this.id = id;
}
	

	public Employee() {
		super();
	}

	public void setManage(Manager manage) {
		this.manage = manage;
	}

		/*
	@OneToOne
	private Dependant dep;
	*/
		@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "manager_id")
	private Manager manage;


	public int getId() {
		return id;
	}
/*
	public Dependant getDep() {
		return dep;
	}

	public void setDep(Dependant dep) {
		this.dep = dep;
	}

	public Manager getManage() {
		return manage;
	}

	public void setManage(Manager manage) {
		this.manage = manage;
	}*/

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
