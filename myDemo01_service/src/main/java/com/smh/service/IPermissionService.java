package com.smh.service;

import com.smh.domain.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> findAll();

    void save(Permission permission);

    void deleteById(Integer id);
}
