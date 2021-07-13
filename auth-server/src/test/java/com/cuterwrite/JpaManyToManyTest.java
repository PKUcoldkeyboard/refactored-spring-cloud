package com.cuterwrite;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.cuterwrite.dao.SysRoleDao;
import com.cuterwrite.dao.SysUserDao;
import com.cuterwrite.entity.SysRole;
import com.cuterwrite.entity.SysUser;

/**  
 * @author Pang S.Z.
 * @create 2021-07-12 21:24:59 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthApplication.class)
public class JpaManyToManyTest {
	
	@Autowired
	private SysUserDao userDao;
	
	@Autowired
	private SysRoleDao roleDao;
	
	
	@Test
	@Transactional
	@Rollback(false)
	public void testSave() {
		
		PasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();
		SysUser user = new SysUser();
		user.setUsername("cuterwrite");
		user.setPassword(passwordEncoder.encode("heart39100"));
		
		SysRole role = new SysRole();
		role.setRoleName("ROLE_ADMIN");
		
		role.getUsers().add(user);
		user.getRoles().add(role);
		
		userDao.save(user);
		roleDao.save(role);
	}
}
