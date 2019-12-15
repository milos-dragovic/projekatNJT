package com.durag.service;

import java.util.List;

import com.durag.model.User;


/**
 * UserService interfejs
 * */
public interface UserService{
	
	User findByUserName(String userName);
	User save(User user);
	List<User> findAllUsers();
	
}
