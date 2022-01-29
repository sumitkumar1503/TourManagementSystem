package com.lc.model;

import org.springframework.web.multipart.MultipartFile;

public class User {
	String name;
	String mobile;
	String address;
	String email;
	String password;
	MultipartFile profileimg;
	
	
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", mobile=" + mobile + ", address=" + address + ", email=" + email + ", password="
				+ password + ", profileimg=" + profileimg + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public MultipartFile getProfileimg() {
		return profileimg;
	}
	public void setProfileimg(MultipartFile profileimg) {
		this.profileimg = profileimg;
	}
	
	
	
}
