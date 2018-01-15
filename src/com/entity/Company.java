package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Company {
	@Entity(name = "company")
	public class Employee {
		@Id
		@Column(name = "id")
		private int id;

		@Column(name = "name")
		private String name;

		/*@Column(name = "address")
		private String address;

		@Column(name = "salary")
		private String email;
		
		@Column(name="age")
		private int age;
*/
		
		@OneToOne(cascade=CascadeType.REMOVE)
		private Employee emp;
		
	public Employee getEmp() {
			return emp;
		}
		public void setEmp(Employee emp) {
			this.emp = emp;
		}
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String cname) {
		this.name = cname;
	}
	
	

}
}