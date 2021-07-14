package com.cuterwrite.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.cuterwrite.dao.SysUserDao;
import com.cuterwrite.entity.SysUser;

/**  
 * @author Pang S.Z.
 * @create 2021-07-14 15:45:52 
 */
@DubboService(cluster = "failfast")
public class UserService implements IUserService{
	
	@Autowired
	SysUserDao dao;

	@Override
	public List<SysUser> getList() {
		return dao.findAll();
	}

	@Override
	public SysUser getOne(Long id) {
		return dao.findById(id).get();
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
		dao.save(oldUser);
	}

	@Override
	public void deleteOne(Long id) {
		dao.deleteById(id);
	}

	@Override
	public SysUser getByUsername(String username) {
		return dao.findByUsername(username);
	}

}
