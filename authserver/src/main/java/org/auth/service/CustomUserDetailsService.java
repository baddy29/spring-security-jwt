package org.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.auth.model.CustomUser;
import org.auth.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private static final String USER_GRANT = "USER";
	private static final String ADMIN_GRANT = "ADMIN";
	private static final List<String> GRANTS = new ArrayList<>();

	private Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	@Autowired
	UserEntityDetailsService userEntityDetailsService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		logger.debug("Loading username");
		try {
			/** Below call can be used to hit db to extract users. */
			// UserEntity userEntity = userEntityDetailsService.getUserDetails(username);
			// Hard-coded user object is created to load user
			UserEntity userEntity = new UserEntity();
			userEntity.setEmailId("john@gmail.com");
			userEntity.setName("John");
			userEntity.setId("1");
			userEntity.setPassword("password");
			userEntity.setGrantedAuthorities(updateGrants(new ArrayList<GrantedAuthority>()));
			if (userEntity != null && userEntity.getId() != null && !"".equalsIgnoreCase(userEntity.getId())) {
				CustomUser customUser = new CustomUser(userEntity);
				logger.debug("custom user created");
				return customUser;
			} else {
				throw new UsernameNotFoundException("User " + username + " was not found in the database");
			}
		} catch (Exception e) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}

		// return new User("foo", "foo", new ArrayList<>());
	}

	/**
	 * @javadoc Logic implemented to add grants to a emoty grant list
	 **/
	private List<GrantedAuthority> updateGrants(List<GrantedAuthority> grantedAuthorities) {
		GRANTS.add(USER_GRANT);
		GRANTS.add(ADMIN_GRANT);
		for (String role : GRANTS) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
			grantedAuthorities.add(grantedAuthority);
		}
		logger.debug("grants given");
		return grantedAuthorities;
	}
}
