package com.oneToMany;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accounts {
	
	@Id
	private int id;
	private int accno;
	private double bal;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	@Override
	public String toString() {
		return "Accounts [id=" + id + ", accno=" + accno + ", bal=" + bal + "]";
	}

}