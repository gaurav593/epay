package com.cgi.soa.masterclass.epay.faces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cgi.soa.masterclass.epay.model.UserEntity;
import com.cgi.soa.masterclass.epay.service.UserDAOInterface;

@Named
@RequestScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1966957573249891139L;
	
	private List<UserEntity> users;
	private UserEntity user;
	
	@Inject
	private UserDAOInterface userAccess;
	
	public UserBean(){
		users = new ArrayList<UserEntity>();
		user = new UserEntity();
	}
	
	@PostConstruct
	private void init(){
		updateUsers();
	}

	public String createUser(){
		userAccess.createUser(user);
		updateUsers();
		return "/users/index";
	}
	
	private void updateUsers(){
		users = userAccess.getAllUsers();
	}
	
	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}	
}
