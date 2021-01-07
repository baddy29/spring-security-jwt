package org.resource.model;
/**
 * @javadoc
 * AccessTokenMapper is used to map json info, 
 * decrypted from jwt passed from webservice request 
 **/
public class AccessTokenMapper {
	
	private String accessToken;
	private String id;
	private String username;
	private String name;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
