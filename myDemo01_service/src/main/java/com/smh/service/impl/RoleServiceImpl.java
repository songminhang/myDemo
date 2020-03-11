package com.smh.service.impl;

import com.smh.dao.IRoleDao;
import com.smh.domain.Permission;
import com.smh.domain.Role;
import com.smh.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/22 14:07
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleDao iRoleDao;

    @Override
    public List<Role> findAll() {
        return iRoleDao.findAll();
    }

    @Override
    public void save(Role role) {
        iRoleDao.save(role);
    }

    @Override
    public Role findById(Integer id) {
        return iRoleDao.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        //删除用户角色表关联
        iRoleDao.deleteByRoleIdFromUR(id);
        //删除权限角色表关联
        iRoleDao.deleteByRoleIdFromPR(id);
        //删除角色表
        iRoleDao.deleteById(id);
    }

    @Override
    public List<Permission> findRoleByIdAndAllPermission(Integer id) {
        return iRoleDao.findRoleByIdAndAllPermission(id);
    }

    @Override
    public void addPermissionToRole(Integer roleId, Integer[] permissionIds) {
        for (Integer permissionId : permissionIds){
            iRoleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
