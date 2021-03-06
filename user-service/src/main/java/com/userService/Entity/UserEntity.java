package com.userService.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserEntity {

	@Id
	private String userName;
	private String emailId;
	private String fullName;
	private int age;
	private String password;
	private Date dateOfBirth;
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(long contactNumber) {
		ContactNumber = contactNumber;
	}

	private long ContactNumber;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public UserEntity(int id, int age, String userName, String password, Date dateOfBirth, long contactNumber,
			String emailId, String fullName) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.userName = userName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		ContactNumber = contactNumber;
		this.emailId = emailId;
	}

	public UserEntity(String emailId, String fullName) {
		super();
		this.fullName = fullName;
		this.emailId = emailId;
	}

	public UserEntity() {
		super();
	}
}
