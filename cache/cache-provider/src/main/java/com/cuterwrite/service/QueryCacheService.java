package com.cuterwrite.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**  
 * @author Pang S.Z.
 * @create 2021-02-28 15:18:41 
 */
@DubboService
public class QueryCacheService implements IQueryCacheService{
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	@Override
	public String get(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}
}
