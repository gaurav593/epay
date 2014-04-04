package com.cgi.soa.masterclass.epay.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cgi.soa.masterclass.epay.model.TransactionEntity;
import com.cgi.soa.masterclass.epay.model.UserEntity;

@Stateless
public class TransactionsDAO implements TransactionsDAOInterface {
	
	@PersistenceContext
    private EntityManager em; 

//	public List<TransactionEntity> getAllTransactionsForUser(UserEntity user) {
//		UserEntity currentUser = em.merge(user);
//		
//	}

}
