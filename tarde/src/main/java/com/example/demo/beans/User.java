package com.example.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;

import lombok.Builder;

@Entity

@Builder
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uid;
	private String uname;
	
	private String email;
	private String password;
	@Column(columnDefinition = "varchar(255) default 'customer'")
	private String role = "customer";
	private String address;
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User(long uid, String uname, String email, String password, String role, String address) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.email = email;
		this.password = password;
		this.role = role;
		this.address = address;
	}
	public User(long uid, String uname, String email, String password,String address) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.email = email;
		this.password = password;
		this.address = address;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", email=" + email + ", password=" + password + ", role="
				+ role + ", address=" + address + "]";
	}
	
	
}
