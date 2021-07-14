package com.cuterwrite.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**  
 * @author Pang S.Z.
 * @create 2021-07-12 16:14:59 
 */
@Entity
@Table(name = "sys_role")
@Setter
@Getter
public class SysRole implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "role_name", nullable = false, unique = true, length = 20)
	private String roleName;
	
	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value = {"roles"})
	private List<SysUser> users = new ArrayList<SysUser>();
}
