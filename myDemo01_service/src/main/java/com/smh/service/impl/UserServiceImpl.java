package com.smh.service.impl;

import com.smh.dao.IUserDao;
import com.smh.domain.Role;
import com.smh.domain.UserInfo;
import com.smh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**权限控制的业务层实现类（承接spring-security的控制）
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/21 13:32
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao iUserDao;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    /**User实现了UserDetails接口并有构造方法可以完成角色对象和UserDetails的转换，对框架友好
     * @param s
     * @return: org.springframework.security.core.userdetails.UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = iUserDao.findByUsername(s);
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }
    /**根据用户关联的角色集合
     * @param roles
     * @return: java.util.List<org.springframework.security.core.authority.SimpleGrantedAuthority>
     */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles){
            list.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() {
        return iUserDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        //使用BCryptPasswordEncoder.encode的方法加密密码
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        iUserDao.save(userInfo);
    }

    @Override
    public UserInfo findById(Integer id) {
        return iUserDao.findById(id);
    }

    @Override
    public List<Role> findUserByIdAndAllRole(Integer id) {
        return iUserDao.findUserByIdAndAllRole(id);
    }

    @Override
    public void addRoleToUser(Integer userId, Integer[] roleIds) {
        for (Integer roleId : roleIds){
            iUserDao.addRoleToUser(userId,roleId);
        }
    }
}
