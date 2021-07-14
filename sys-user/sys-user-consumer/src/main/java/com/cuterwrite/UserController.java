package com.cuterwrite;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuterwrite.entity.SysUser;
import com.cuterwrite.result.Result;
import com.cuterwrite.service.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;


/**  
 * @author Pang S.Z.
 * @create 2021-07-14 15:30:57 
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@DubboReference
	IUserService service;
	
	@GetMapping("/")
	public Result getList() {
		List<SysUser> userList = service.getList();
		return Result.ok(userList);
	}
	
	@GetMapping("/{id}")
	public Result getById(@PathVariable Long id) throws JsonProcessingException {
		SysUser user = service.getOne(id);
		return Result.ok(user);
	}
	
	@PostMapping("/")
	public Result create(@RequestBody SysUser user) {
		String pass = user.getPassword();
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(pass));
		service.addOne(user);
		return Result.ok();
	}
	
	@PutMapping("/")
	public Result update(@RequestBody SysUser user) {
		service.updateOne(user);
		return Result.ok();
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable Long id) {
		service.deleteOne(id);
		return Result.ok();
	}
}
