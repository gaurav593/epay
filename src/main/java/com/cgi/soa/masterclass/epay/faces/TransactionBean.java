package com.cgi.soa.masterclass.epay.faces;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cgi.soa.masterclass.epay.model.FeeEntity;
import com.cgi.soa.masterclass.epay.model.TransactionEntity;
import com.cgi.soa.masterclass.epay.model.UserEntity;
import com.cgi.soa.masterclass.epay.service.BankWS;
import com.cgi.soa.masterclass.epay.service.TransactionsDAOInterface;
import com.cgi.soa.masterclass.epay.service.UserDAOInterface;

@Named
@RequestScoped
public class TransactionBean implements Serializable {

	private static final long serialVersionUID = 325312394674822484L;

	private UserEntity user;
	private TransactionEntity transaction;

	@Inject
	TransactionsDAOInterface transAccess;

	@Inject
	BankWS service;

	@Inject
	UserDAOInterface userAccess;

	public TransactionBean() {
		this.transaction = new TransactionEntity();
	}

	public String depositTransaction() {
		if (service.getWebService().isBalanceCovered(
				(Integer) user.getAccNumber(),
				new BigDecimal(transaction.getAmount()))) {
			service.getWebService().transfer(48, user.getAccNumber(),
					transaction.getPurpose(),
					new BigDecimal(transaction.getAmount()));
			FeeEntity fee = new FeeEntity();
			fee.setAmount(0);
			transaction.setFee(fee);
			user.getTransactions().add(transaction);
			userAccess.updateUser(user);
			return "/transactions/index?userID=" + user.getUserID();
		} else {
			return "";
		}
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public TransactionEntity getTransaction() {
		return transaction;
	}

	public void setTransaction(TransactionEntity transaction) {
		this.transaction = transaction;
	}
}
