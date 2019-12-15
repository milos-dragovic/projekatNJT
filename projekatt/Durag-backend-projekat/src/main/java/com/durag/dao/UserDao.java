package com.durag.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.durag.model.User;

/**
 * User DAO (Data-Access-Object) interfejs 
 * nasledjuje genericki Springov CRUD-Repository interfejs za User model  
 * 
 * */

@Repository
public interface UserDao extends CrudRepository<User, Long>{

	
	User findByUserName(String userName);
	User save(User user);
	User findByUserId(Long id);
	List<User> findAll();
	
	
}
