package com.durag.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.durag.model.User;
import com.durag.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * User controller
 * 
 * delegacija korisnickih zahteva prilikom 
 * logina i registracije
 * 
 * */

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestBody Map<String, String> json) throws ServletException {
		if (json.get("username") == null || json.get("password") == null) {
			throw new ServletException("Please fill in all fields"); //ukoliko su nekad od polja null baci izuzetak
		}
		
			//uzmi username i password
		final String userName = json.get("username"); 
		final String password = json.get("password");
		
			//pronadji korisnika
		User user = userService.findByUserName(userName);
		if (user == null) {
			throw new ServletException("User not found."); //ne postoji takav korisnik
		}
		
			//ukoliko postoji korisnik, uzmi njegovu sifru
		String userPassword = user.getPassword();

		if (!password.equals(userPassword)) {
			throw new ServletException("Error login, check your username and password, again");
		}
		return Jwts.builder().setSubject(userName).claim("roles", "user").setIssuedAt(new Date()) //setovanje keljmova
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();  // digitalni potpis JWT SHA-256 algortmom u JWS i vracanje celog tokena
	}

	/** Registracija korisnika
	 *  @return User
	 * */
	//@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User registerUser(final @RequestBody User user) {
	
		// System.out.println(user);
		// String username = user.getUserName();
		// System.out.println(username);
		// User user1 ;
		// user1= userService.findByUserName(user.getUserName());
		// String userStr = null;
		// if(user1!=null) {
		// 	System.out.println("User already exist");
		// 	return "null";
		// }else {
		// 	user1 = userService.save(user);
		// 	try {
		// 		userStr = new ObjectMapper().writeValueAsString(user1);
		// 	} catch (JsonProcessingException e) {
		// 		// TODO Auto-generated catch block
		// 		e.printStackTrace();
		// 	}
		// 	return userStr;
		System.out.println(user);
		final String username = user.getUserName();
		System.out.println(username);
		User user1 = userService.findByUserName(username);
		if(user1!=null) {
			System.out.println("User already exist");
			return null;
		}else {
			return userService.save(user); //dodaj novog korisnika
		}
		 
	}
}
