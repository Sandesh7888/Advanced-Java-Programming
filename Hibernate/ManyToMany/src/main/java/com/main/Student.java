package com.main;

import java.util.List;

import javax.persistence.*;


@Entity
public class Student {
	
	@Id
	
	private int id;
	private String name;
	private long mobile;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name="stu_id"),
	inverseJoinColumns = @JoinColumn(name="sub_id"))
	private List<Subject> subject;

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

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobile=" + mobile + ", subject=" + subject + "]";
	}
	
	
	
}
