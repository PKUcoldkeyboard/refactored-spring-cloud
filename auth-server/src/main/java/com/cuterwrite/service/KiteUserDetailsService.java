package com.cuterwrite.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

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
	
	@DubboReference
	IUserService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("username is:" + username);
		//查询数据库，todo
		SysUser user = service.getByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("the user is not found");
		} else {
			//查询角色,todo
			/*
			 * Iterator<SysRole> roles = user.getRoles().iterator(); SysRole role =
			 * roles.next();
			 */
			List<SysRole> roles = user.getRoles();
			List<SimpleGrantedAuthority> authorities = new ArrayList<>();
			for (SysRole role : roles) {
				authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			}
			//查询密码
			String password = user.getPassword();
			return new User(username, password, authorities);
		}
	}

}
