package org.auth.config;

import javax.servlet.http.HttpServletResponse;

import org.auth.service.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	private final Logger logger = LoggerFactory.getLogger(OAuth2Config.class);

	@Autowired
	CustomUserDetailsService customUserDetailsService;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("foo").password("bar").roles("ADMIN");
		auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder());
		logger.debug("password encoded user created");
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder encoder() {
		logger.debug("encoder");
		return NoOpPasswordEncoder.getInstance();
	}
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.debug("configuring http session");
		  http.authorizeRequests().anyRequest().authenticated().and().sessionManagement
		  ().sessionCreationPolicy(SessionCreationPolicy.NEVER);
		 
		  http
		    .exceptionHandling()
		    .authenticationEntryPoint((request, response, e) -> 
		    {
		        response.setContentType("application/json;charset=UTF-8");
		        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		        response.getWriter().write("exception occured with http security configurer");
		    });
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		logger.debug("auth manager bean");
		return super.authenticationManagerBean();
	}
	
}
