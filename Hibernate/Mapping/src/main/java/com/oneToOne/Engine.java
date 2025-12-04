package com.oneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Engine {
	
	@Id
	private int id;
	private int hp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	
}