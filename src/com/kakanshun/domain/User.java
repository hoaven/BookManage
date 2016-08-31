package com.kakanshun.domain;

import java.io.Serializable;

public class User implements Serializable {
	private int id;
	private String username;
	private String password;
	private String num;
	private int ulimit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getUlimit() {
		return ulimit;
	}
	public void setUlimit(int ulimit) {
		this.ulimit = ulimit;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", num=" + num + ", ulimit=" + ulimit + "]";
	}
	
	
}
