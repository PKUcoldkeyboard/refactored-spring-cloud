package com.cuterwrite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**  
 * @author Pang S.Z.
 * @create 2021-07-12 16:09:03 
 */
@Configuration
public class JWTTokenStore {
	@Bean
	public TokenStore jwtTokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey("dev");
		return accessTokenConverter;
	}
}
