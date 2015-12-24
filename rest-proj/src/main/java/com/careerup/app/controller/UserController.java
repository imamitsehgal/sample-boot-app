package com.careerup.app.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.careerup.app.model.User;
import com.careerup.app.model.repo.UserRepository;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
	
	
	@RequestMapping(path = "/user" ,method = RequestMethod.POST )
	public Map<String,Object> createUser(@RequestBody Map<String,Object>userMap){
		User user = User.getUserBean(userMap);
		userRepo.save(user);
		Map<String,Object> response = new LinkedHashMap<String,Object>();
		response.put("message", "UserCreated");
		response.put("user", user);
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/user/{userId}")
	public User getUserDetails(@PathVariable("userId")String userId){
		return userRepo.findOne(userId);
	}
	
	@RequestMapping(path = "/user" ,method = RequestMethod.GET)
	public Map<String,Object> getAllUserDetails(){
		List<User> users  = userRepo.findAll();
		Map<String,Object> response = new LinkedHashMap<String,Object>();
		response.put("users", users);
		Logger.getLogger(this.getClass().getName()).debug("GET request");
		return response;
	}
	


}
