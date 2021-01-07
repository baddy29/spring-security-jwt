package org.auth.model;

import java.io.Serializable;

import org.springframework.security.core.userdetails.User;

/**
 * This model is wrapper over {@link User}
 **/
public class CustomUser extends User implements Serializable {

	/**
	 * @author SHIVAM
	 */
	private static final long serialVersionUID = -1810419386962904457L;
	private String id;
	private String name;

	public CustomUser(UserEntity userEntity) {
		super(userEntity.getEmailId(), userEntity.getPassword(), userEntity.getGrantedAuthorities());
		this.id = userEntity.getId();
		this.name = userEntity.getName();
	}

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

}
