package com.cgi.soa.masterclass.epay.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "UserEntity.findAll", query = "SELECT e FROM UserEntity e")})
public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = 5172744441961566957L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;
	private String firstName;
	private String lastName;
	@Column(unique=true)
	private String eMail;
	private int accNumber;
	private String accFirstName;
	private String accLastName;
	private double balance;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
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
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public int getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	public String getAccFirstName() {
		return accFirstName;
	}
	public void setAccFirstName(String accFirstName) {
		this.accFirstName = accFirstName;
	}
	public String getAccLastName() {
		return accLastName;
	}
	public void setAccLastName(String accLastName) {
		this.accLastName = accLastName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
