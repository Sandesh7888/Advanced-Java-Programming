package com.oneToMany;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bank {
	
	@Id
	private int id;
	private String name;
	
	@OneToMany
	private List<Accounts> accounts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Accounts> getAccounts() {
		return accounts;
	}
//
	public void setAccounts(List<Accounts> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", accounts=" + accounts + "]";
	}
	
	

}