package com.cuterwrite.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**  
 * @author Pang S.Z.
 * @create 2021-07-12 16:14:53 
 */
@Entity
@Table(name = "sys_user")
@Setter
@Getter
public class SysUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "username", unique = true, nullable = false, length = 64)
	private String username;
	
	@Column(name = "password", nullable = false, length = 80)
	private String password;
	
	@ManyToMany(targetEntity = SysRole.class)
	@JoinTable(name = "sys_user_role", joinColumns = {@JoinColumn(name = "sys_user_id", referencedColumnName = "id")},
			   inverseJoinColumns = {@JoinColumn(name = "sys_role_id",referencedColumnName = "id")})
	private Set<SysRole> roles = new HashSet<>();
}
