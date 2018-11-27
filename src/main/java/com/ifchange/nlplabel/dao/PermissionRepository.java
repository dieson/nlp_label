package com.ifchange.nlplabel.dao;


import com.ifchange.nlplabel.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ClassName: PermissionRepository
 * @Description: 权限
 * @author: Dieson Zuo
 * @date: Created in 10:44 2018/11/16
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    @Query(nativeQuery = true, value = "select * from permission")
    List<Permission> findAll();

    @Query(nativeQuery = true, value = "select p.* from user u LEFT JOIN user_role ur on u.id= ur.user_id LEFT JOIN role r on ur.role_id=r.id LEFT JOIN permission_role pr on pr.role_id=r.id LEFT JOIN permission p on p.id =pr.permission_id where u.id=:userId")
    List<Permission> findByUserId(Long userId);
}
