package com.warehouse.model;

import javax.persistence.*;

@Entity
@Table(name="user_roles")
public class UserRole {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="user_role_id")
	private Long userroleid;

	@ManyToOne(targetEntity = User.class) // FIXME: 14.11.2016 Поменял с старой версии на новую, если возращать копировать с олд версии
	private User userJOIN;
	
	private String role;


	public UserRole() {
	}

	public UserRole(String role) {
		this.role = role;
	}

	public UserRole(User userJOIN, String role) {
		this.userJOIN = userJOIN;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUserJOIN() {
		return userJOIN;
	}

	public void setUserJOIN(User userid) {
		this.userJOIN = userid;
	}

	public Long getUserroleid() {
		return userroleid;
	}

	public void setUserroleid(Long userroleid) {
		this.userroleid = userroleid;
	}	
	
}
