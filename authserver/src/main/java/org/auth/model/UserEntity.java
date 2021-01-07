package org.auth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
/**
 * @javadoc
 * This model is wrapper over 
 * {@link CustomUser}.
 * It is used to create user object for loading
 * user from @link {@link User} entity*/
public class UserEntity implements Serializable{

	/**
	 * @author SHIVAM
	 */
	private static final long serialVersionUID = 931046390258072107L;
	private String id;
	private String name;
	private String emailId;
	private String password;
	private Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Collection<GrantedAuthority> getGrantedAuthorities() {
		return grantedAuthorities;
	}
	public void setGrantedAuthorities(Collection<GrantedAuthority> grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
