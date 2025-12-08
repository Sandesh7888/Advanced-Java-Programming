package com.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Battery {
	
	@Id
	private int id;
	private long hp;
	
	@OneToOne(mappedBy = "battery")
	private Mobile mobile;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getHp() {
		return hp;
	}

	public void setHp(long hp) {
		this.hp = hp;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Battery [id=" + id + ", hp=" + hp + "]";
	}
}
