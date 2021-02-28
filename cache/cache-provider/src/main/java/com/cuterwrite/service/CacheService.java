package com.cuterwrite.service;

import java.util.concurrent.TimeUnit;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**  
 * @author Pang S.Z.
 * @create 2021-02-28 15:07:58 
 */
@DubboService(cluster = "failfast")
public class CacheService implements ICacheService{
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Override
	public void put(String key, String value) {
		stringRedisTemplate.opsForValue().set(key, value);
	}

	@Override
	public void put(String key, String value, Integer seconds) {
		stringRedisTemplate.opsForValue().set(key, value,seconds,TimeUnit.SECONDS);
	}

	@Override
	public void remove(String key) {
		stringRedisTemplate.delete(key);
	}

}
