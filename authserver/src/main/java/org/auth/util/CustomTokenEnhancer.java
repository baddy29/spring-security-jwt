package org.auth.util;

import java.util.HashMap;
import java.util.Map;

import org.auth.model.CustomUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
/**
 * @javadoc
 * Custom token enhancer overrides JwtAccessTokenConverter,
 * to create signtaured access token
 **/
public class CustomTokenEnhancer extends JwtAccessTokenConverter {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		Map<String, Object> userInfo = new HashMap<String,Object>() ;
		if (customUser.getId() != null)
			userInfo.put("id", customUser.getId());
		if (customUser.getName() != null)
			userInfo.put("name", customUser.getName());
		if (customUser.getUsername() != null)
			userInfo.put("userName", customUser.getUsername());
		DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
		customAccessToken.setAdditionalInformation(userInfo);
		return super.enhance(customAccessToken, authentication);
	}

}
