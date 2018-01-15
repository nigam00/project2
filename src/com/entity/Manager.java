package com.entity;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "manager")
public class Manager {
	
	@Id
	@Column(name="manager_id")
	private int mid;
	
	@Column(name="department")
	private String dept;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Employee emp;

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	/*public int getEmid() {
		return emid;
	}

	public void setEmid(int emid) {
		this.emid = emid;
	}*/

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	

}
