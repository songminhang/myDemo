package com.smh.service.impl;

import com.smh.dao.IPermissionDao;
import com.smh.domain.Permission;
import com.smh.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/22 16:41
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    IPermissionDao iPermissionDao;

    @Override
    public List<Permission> findAll() {
        return iPermissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        iPermissionDao.save(permission);
    }

    @Override
    public void deleteById(Integer id) {
        iPermissionDao.deleteByIdFromPR(id);
        iPermissionDao.deleteById(id);
    }
}
