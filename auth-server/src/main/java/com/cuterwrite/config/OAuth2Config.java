package com.cuterwrite.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.JdbcClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**  
 * @author Pang S.Z.
 * @create 2021-07-12 15:48:29 
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserDetailsService kiteUserDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenStore jwtTokenStore;
	
	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		//redis token 方式
		endpoints.authenticationManager(authenticationManager)
				.userDetailsService(kiteUserDetailsService)
				.accessTokenConverter(jwtAccessTokenConverter)
				.tokenStore(jwtTokenStore);
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		JdbcClientDetailsServiceBuilder builder = clients.jdbc(dataSource);
		builder.passwordEncoder(passwordEncoder);
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.allowFormAuthenticationForClients();
		security.checkTokenAccess("isAuthenticated()");
		security.tokenKeyAccess("isAuthenticated()");
	}
}
