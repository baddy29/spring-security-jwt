package org.auth.model;

/**
 * @javadoc This model is used when 'secret' key is used when manual
 *          request('/authenticate') is used instead of using '/oauth/token'
 */
public class AuthenticationResponse {
	private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
