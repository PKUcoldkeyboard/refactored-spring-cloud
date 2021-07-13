package com.cuterwrite.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cuterwrite.dao.SysUserDao;
import com.cuterwrite.entity.SysRole;
import com.cuterwrite.entity.SysUser;

import lombok.extern.slf4j.Slf4j;

/**  
 * @author Pang S.Z.
 * @create 2021-07-12 15:44:12 
 */
@Slf4j
@Component(value = "kiteUserDetailsService")
public class KiteUserDetailsService implements UserDetailsService {
	
	@Autowired
	private SysUserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("username is:" + username);
		//查询数据库，todo
		SysUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("the user is not found");
		} else {
			//查询角色,todo
			/*
			 * Iterator<SysRole> roles = user.getRoles().iterator(); SysRole role =
			 * roles.next();
			 */
			String roleName = "ROLE_ADMIN";
			List<SimpleGrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(roleName));
			//查询密码
			String password = user.getPassword();
			return new User(username, password, authorities);
		}
	}

}
