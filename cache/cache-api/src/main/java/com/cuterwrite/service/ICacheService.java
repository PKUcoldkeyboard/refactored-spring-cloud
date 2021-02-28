package com.cuterwrite.service;
/**  
 * 缓存服务接口
 * @author Pang S.Z.
 * @create 2021-02-28 15:02:19 
 */
public interface ICacheService {
	
	void put(String key,String value);
	
	void put(String key,String value,Integer seconds);
	
	void remove(String key);
}
