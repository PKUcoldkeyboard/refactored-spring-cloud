package com.cuterwrite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cuterwrite.entity.SysRole;

/**  
 * @author Pang S.Z.
 * @create 2021-07-12 21:23:37 
 */
@Repository
public interface SysRoleDao extends JpaRepository<SysRole, Long>, JpaSpecificationExecutor<SysRole> {

}
