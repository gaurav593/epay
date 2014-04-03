package com.cgi.soa.masterclass.epay.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cgi.soa.masterclass.epay.model.UserEntity;

@Stateless
public class UserDAO implements UserDAOInterface{
	
	@PersistenceContext
    private EntityManager em;  

	public void createUser(UserEntity user) {
		em.persist(user);
	}

	@SuppressWarnings("unchecked")
	public List<UserEntity> getAllUsers() {
		List<UserEntity> customers = new ArrayList<UserEntity>();
		Query query = em.createNamedQuery("Select u from user u");
		customers = query.getResultList();
		return customers;
	}

}
