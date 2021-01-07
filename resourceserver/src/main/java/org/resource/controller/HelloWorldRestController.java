package org.resource.controller;

import javax.annotation.security.RolesAllowed;

import org.resource.model.AccessTokenMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {
	private final Logger logger = LoggerFactory.getLogger(HelloWorldRestController.class);

	 @RolesAllowed("USER") 
//	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String helloWorld() {

		/*
		 * AccessTokenMapper
		 * accessTokenMapper=(AccessTokenMapper)((OAuth2Authentication)
		 * SecurityContextHolder.getContext().getAuthentication().getDetails()).
		 * getDetails(); logger.debug("username"+accessTokenMapper.getUsername());
		 */

		return "Hello World";
	}
}
