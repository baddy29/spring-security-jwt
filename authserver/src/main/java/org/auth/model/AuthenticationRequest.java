package org.auth.model;

import java.io.Serializable;

/**
 * @javadoc This model is used when 'secret' key is used when manual
 *          request('/authenticate') is used instead of using '/oauth/token'
 */
public class AuthenticationRequest implements Serializable {

	/**
	 * @author SHIVAM
	 */
	private static final long serialVersionUID = -4253953784158584971L;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// need default constructor for JSON Parsing
	public AuthenticationRequest() {

	}

	public AuthenticationRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
}
