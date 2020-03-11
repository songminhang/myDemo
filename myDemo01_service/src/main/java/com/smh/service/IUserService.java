package com.smh.service;


import com.smh.domain.Role;
import com.smh.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(Integer id);

    List<Role> findUserByIdAndAllRole(Integer id);

    void addRoleToUser(Integer userId, Integer[] roleIds);
}
