package com.te.StudentProject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "student_info")
public class Student {
	@Id
	@Column(name = "s_id")
	private int rollno;
	@Column(name = "s_name")
	private String name;
	@Column(name = "s_phno")
	private long phno;
	@Column(name = "s_dob")
	private Date dob;

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "rollno=" + rollno + ", name=" + name + ", phno=" + phno + ", dob=" + "dob]";
	}

	public Student() {
	}
}
