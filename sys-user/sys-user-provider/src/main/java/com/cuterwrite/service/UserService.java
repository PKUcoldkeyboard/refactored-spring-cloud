package com.cuterwrite.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.cuterwrite.dao.SysUserDao;
import com.cuterwrite.entity.SysUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**  
 * @author Pang S.Z.
 * @create 2021-07-14 15:45:52 
 */
@DubboService(cluster = "failfast")
public class UserService implements IUserService{
	
	@Autowired
	SysUserDao dao;
	
	@DubboReference
	ICacheService cacheService;
	
	@DubboReference
	IQueryCacheService queryCacheService;
	
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public List<SysUser> getList() {
		return dao.findAll();
	}

	@Override
	public SysUser getOne(Long id) throws JsonProcessingException {
		//先从redis缓存中获取数据
		String data = queryCacheService.get("user_" + id);
		//System.out.println(data);
		SysUser user = null;
		//如果缓存中没有，则从数据库中查询并放入缓存中
		if (data == null) {
			user = dao.findById(id).get();
			if (user != null) {
				//这里有一个坑：SysUser对象里是有SysRole的数组的，需要使用@JSonIgnoreProperties处理
				//这个注解是Jackson提供的，所以需要使用jackson
				cacheService.put("user_" + id, mapper.writeValueAsString(user));
			}
		} else {
			//user = BeanUtil.toBean(queryCacheService.get("user_" + id), SysUser.class);
			String json = queryCacheService.get("user_" + id);
			user = mapper.readValue(json, SysUser.class);
		}
		return user;
	}

	@Override
	public void addOne(SysUser user) {
		dao.save(user);
	}

	@Override
	public void updateOne(SysUser user) {	
		Long userId = user.getId();
		SysUser oldUser = dao.findById(userId).get();
		oldUser.setRoles(user.getRoles());
		//删除redis中的缓存
		cacheService.remove("user_" + userId);
		dao.save(oldUser);
	}

	@Override
	public void deleteOne(Long id) {
		//删除redis中的缓存
		cacheService.remove("user_" + id);
		dao.deleteById(id);
	}

	@Override
	public SysUser getByUsername(String username) {
		return dao.findByUsername(username);
	}

}
