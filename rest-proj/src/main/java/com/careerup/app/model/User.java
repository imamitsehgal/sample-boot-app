package com.careerup.app.model;

import java.net.URI;
import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;

public class User {
	@Id
	private String id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private URI pictureURI;
	private String[] skills;
	private String linkedInId;
	private Date careerStartDate;
	
	
	public User(String id, String username, String firstName, String lastName, String email, URI pictureURI,
			String[] skills, String linkedInId, Date careerStartDate) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pictureURI = pictureURI;
		this.skills = skills;
		this.linkedInId = linkedInId;
		this.careerStartDate = careerStartDate;
	}


	public static User getUserBean(Map<String,Object> userAttributes){
		return new User((String)userAttributes.get("id"),
				(String)userAttributes.get("username"),
				(String)userAttributes.get("firstName"),
				(String)userAttributes.get("lastName"),
				(String)userAttributes.get("email"),
				(URI)userAttributes.get("pictureURI"),
				(String[])userAttributes.get("skills"),
				(String)userAttributes.get("linkedInId"),
				(Date)userAttributes.get("careerStartDate"));
	}
}
