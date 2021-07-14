package com.cuterwrite.service;

import java.util.List;

import com.cuterwrite.entity.SysUser;

/**  
 * @author Pang S.Z.
 * @create 2021-07-14 15:23:05 
 */
public interface IUserService {
	List<SysUser> getList();
	SysUser getByUsername(String username);
	SysUser getOne(Long id);
	void addOne(SysUser user);
	void updateOne(SysUser user);
	void deleteOne(Long id);	
}
