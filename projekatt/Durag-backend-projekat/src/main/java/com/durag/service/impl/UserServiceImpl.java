package com.durag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durag.dao.UserDao;
import com.durag.model.User;
import com.durag.service.UserService;


/**
 * Implementacija User Service interfejsa
 * pristup bazi pomocu User-DAO 
 * 
 * */
@Service
public class UserServiceImpl implements UserService{

	
	/** UserDAO instanca*/
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> findAllUsers() {
		return userDao.findAll();  //vraca listu svih korisnika
	}
	@Override
	public User save(User user) {
		return userDao.save(user); //cuva korisnika u bazu
	}
	@Override
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName); //Vraca korisnika po username-u
	}

	
	
}
