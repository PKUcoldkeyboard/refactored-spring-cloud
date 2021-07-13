package com.cuterwrite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cuterwrite.entity.SysUser;

/**  
 * @author Pang S.Z.
 * @create 2021-07-12 21:22:29 
 */
@Repository
public interface SysUserDao extends JpaRepository<SysUser, Long>, JpaSpecificationExecutor<SysUser>{
	SysUser findByUsername(String username);
}
