package com.cg.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name = "user_id")
	String userId;
	@Column(name = "first_name")
	String firstName;
	@Column(name = "last_name")
	String lastName;
	@Column(name="contact")
	String contact;
	@Column(name = "city")
	String city;
	@Column(name = "pass")
	String pass;
	public User() {
		super();
	}
	public User(String userId, String firstName, String lastName, String contact, String city, String pass) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.city = city;
		this.pass = pass;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "User [UserId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", contact=" + contact
				+ ", city=" + city + ", pass=" + pass + "]";
	}
	
}
