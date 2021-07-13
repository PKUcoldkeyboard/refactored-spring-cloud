package com.cuterwrite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**  
 * @author Pang S.Z.
 * @create 2021-07-12 15:54:18 
 */
//@Configuration
public class RedisTokenStoreConfig {

	@Autowired
	private RedisConnectionFactory redisConnectionFactory;
	
	@Bean
	public TokenStore redisTokenStore() {
		return new RedisTokenStore(redisConnectionFactory);
	}
}
