package com.cgi.soa.masterclass.epay.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class FeeEntity implements Serializable {

	
	private static final long serialVersionUID = -1277699830476418791L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int feeID;
	@OneToOne
	@JoinColumn
	private TransactionEntity transaction;
	private float amount;
	
	public int getFeeID() {
		return feeID;
	}
	public void setFeeID(int feeID) {
		this.feeID = feeID;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public TransactionEntity getTransaction() {
		return transaction;
	}
	public void setTransaction(TransactionEntity transaction) {
		this.transaction = transaction;
	}
	

}
