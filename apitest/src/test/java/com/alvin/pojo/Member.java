package com.alvin.pojo;

import java.math.BigDecimal;
import java.sql.Date;

public class Member {
	
	private int id ;
	private String name ;
	private String sex ;
	private String addr ;
	private int age ;
	private String email ;
	private Date reg_time ;
	private BigDecimal amount ;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getReg_time() {
		return reg_time;
	}
	public void setReg_time(Date reg_time) {
		this.reg_time = reg_time;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(int id, String name, String sex, String addr, int age, String email, Date reg_time,
			BigDecimal amount) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.addr = addr;
		this.age = age;
		this.email = email;
		this.reg_time = reg_time;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", sex=" + sex + ", addr=" + addr + ", age=" + age + ", email="
				+ email + ", reg_time=" + reg_time + ", amount=" + amount + "]";
	}



}
