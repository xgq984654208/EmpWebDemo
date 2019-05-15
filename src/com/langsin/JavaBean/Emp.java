package com.langsin.JavaBean;

import java.math.BigDecimal;

public class Emp {
	private int empno;
	private String ename;
	private String gender;
	private String job;
	private BigDecimal sal;
	private BigDecimal COMM;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public BigDecimal getSal() {
		return sal;
	}
	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}
	public BigDecimal getCOMM() {
		return COMM;
	}
	public void setCOMM(BigDecimal COMM) {
		this.COMM = COMM;
	}

	
}
