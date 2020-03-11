package com.smh.service;

import com.smh.domain.Permission;
import com.smh.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll();

    void save(Role role);

    Role findById(Integer id);

    void deleteById(Integer id);

    List<Permission> findRoleByIdAndAllPermission(Integer id);

    void addPermissionToRole(Integer roleId, Integer[] permissionIds);
}
