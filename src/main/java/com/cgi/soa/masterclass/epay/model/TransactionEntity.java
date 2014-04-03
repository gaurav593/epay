package com.cgi.soa.masterclass.epay.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TransactionEntity implements Serializable{

	private static final long serialVersionUID = 534607364089649789L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionID;
	@ManyToOne
	@JoinColumn
	private UserEntity sender;
	@ManyToOne
	@JoinColumn
	private UserEntity recipient;
	@Temporal(TemporalType.DATE)
	private Date transDate;	
	private String purpose;
	private float amount;
	@OneToOne(mappedBy="transaction")
	private FeeEntity fee;
	
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public UserEntity getSender() {
		return sender;
	}
	public void setSender(UserEntity sender) {
		this.sender = sender;
	}
	public UserEntity getRecipient() {
		return recipient;
	}
	public void setRecipient(UserEntity recipient) {
		this.recipient = recipient;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public FeeEntity getFee() {
		return fee;
	}
	public void setFee(FeeEntity fee) {
		this.fee = fee;
	} 
	
}
	
	

