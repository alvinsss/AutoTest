package com.alvin.pojo;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class Member {
	
	private int id ;
	private String name ;
	private String sex ;
	private String addr ;
	private int age ;
	private String email ;
	private Timestamp reg_time ;
	private BigDecimal leave_amount ;
	private String mobile_phone;
	private String password ;
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", sex=" + sex + ", addr=" + addr + ", age=" + age + ", email="
				+ email + ", reg_time=" + reg_time + ", leave_amount=" + leave_amount + ", mobile_phone=" + mobile_phone
				+ ", password=" + password + "]";
	}
	public Member(int id, String name, String sex, String addr, int age, String email, Timestamp reg_time,
			BigDecimal leave_amount, String mobile_phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.addr = addr;
		this.age = age;
		this.email = email;
		this.reg_time = reg_time;
		this.leave_amount = leave_amount;
		this.mobile_phone = mobile_phone;
		this.password = password;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public Timestamp getReg_time() {
		return reg_time;
	}
	public void setReg_time(Timestamp reg_time) {
		this.reg_time = reg_time;
	}
	public BigDecimal getLeave_amount() {
		return leave_amount;
	}
	public void setLeave_amount(BigDecimal leave_amount) {
		this.leave_amount = leave_amount;
	}
	public String getMobile_phone() {
		return mobile_phone;
	}
	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

 
}