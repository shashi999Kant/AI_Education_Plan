package com.exam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Role
{
   

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long roleId;
    
    private  String roleName;
    
    @ManyToOne
    @JoinColumn(name = "user_id") // Adjust the column name based on your actual database schema
    private User user;


    public Role() {

    }

   
	public long getRoleId() {
		return roleId;
	}
 public Role(String roleName) {
		super();
		this.roleName = roleName;
	}


	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Role(long roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

   
}
