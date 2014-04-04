package com.cgi.soa.masterclass.epay.service;

import java.util.List;

import com.cgi.soa.masterclass.epay.model.UserEntity;

public interface UserDAOInterface {
	public void createUser(UserEntity user);
	public List<UserEntity> getAllUsers();
	public UserEntity getUserByID(int ID);
	public void updateUser(UserEntity user);
}
