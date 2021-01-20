package org.resource.config;

import java.util.Map;

import org.resource.model.AccessTokenMapper;
import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

@Component
public class JwtConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer{

	@Override
	public void configure(JwtAccessTokenConverter converter) {
		converter.setAccessTokenConverter(this);		
	}
	
	public OAuth2Authentication extracAuthentication(Map<String,?> map) {
		OAuth2Authentication authentication=super.extractAuthentication(map);
		AccessTokenMapper accessTokenMapper=new AccessTokenMapper();
		if(map.get("id")!=null)
			accessTokenMapper.setId((String)map.get("id"));
		if(map.get("name")!=null)
			accessTokenMapper.setName((String)map.get("name"));
		if(map.get("username")!=null)
			accessTokenMapper.setUsername((String)map.get("username"));
		authentication.setDetails(accessTokenMapper);
		return authentication;
	}

}
