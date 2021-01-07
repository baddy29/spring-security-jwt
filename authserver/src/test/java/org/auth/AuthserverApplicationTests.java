package org.auth;

/**
 * @author SHIVAM
 */
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.auth.model.CustomUser;
import org.auth.model.UserEntity;
import org.auth.service.CustomUserDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This class tests loadUserByUsername method of
 * 
 * @link UserDetailsService
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class AuthserverApplicationTests {

	private static final String USER_GRANT = "USER";
	private static final String ADMIN_GRANT = "ADMIN";
	private static final List<String> GRANTS = new ArrayList<>();
	@MockBean
	CustomUserDetailsService mockUserDetailsService;
	@Autowired
	CustomUserDetailsService userDetailsService;

	@Test
	public void createAuthenticationTokenTest() {
		/* creating new user object for comparison */
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		UserEntity userEntity = new UserEntity();
		userEntity.setEmailId("john@gmail.com");
		userEntity.setName("John");
		userEntity.setId("1");
		userEntity.setPassword("password");
		GRANTS.add(USER_GRANT);
		GRANTS.add(ADMIN_GRANT);
		for (String role : GRANTS) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
			grantedAuthorities.add(grantedAuthority);
		}
		userEntity.setGrantedAuthorities(grantedAuthorities);
		CustomUser user = new CustomUser(userEntity);
		/* calling mock service */
		when(mockUserDetailsService.loadUserByUsername("john@gmail.com")).thenReturn(user);
		assertEquals(user, userDetailsService.loadUserByUsername("john@gmail.com"));
	}

	{
	}

}
