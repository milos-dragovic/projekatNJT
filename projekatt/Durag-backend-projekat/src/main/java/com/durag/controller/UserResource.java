package com.durag.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.durag.model.User;
import com.durag.service.UserService;
 
/**
 * UserResource Rest-Kontroler 
 * 
 * 
 * */
@RestController
@RequestMapping("/rest")
public class UserResource {

	/**instanca UserService implementacije*/
    @Autowired
    private UserService userService;

    @RequestMapping("/user/users")
    public List<User> findAllUsers() { 
    	final List<User> users = userService.findAllUsers(); //Lista svih user
        return users; 
    }
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        final User updatedUser= userService.save(user);  // apdejtovan user
        System.out.println(updatedUser);
		return updatedUser;
    }
    @RequestMapping(value = "/user/userName", method = RequestMethod.POST)
    public User findByUserName(@RequestBody String userName) {
        System.out.println(userName);
        final User user = userService.findByUserName(userName); // vrati korisnika po imenu
        return user;
    }
    
}
