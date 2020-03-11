package com.smh.dao;

import com.smh.domain.Role;
import com.smh.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {
    @Select("select * from users where username = #{username}")
    @Results(id = "userMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = List.class,many = @Many(select = "com.smh.dao.IRoleDao.findByUserId"))
    })
    UserInfo findByUsername(String username);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users(username,password,email,phoneNum,status) values(#{username},#{password},#{email},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from users where id = #{id}")
    @ResultMap("userMap")
    UserInfo findById(Integer id);

    @Select("select * from role where id not in(select id from role r,users_role ur where r.id = ur.roleId and ur.userId = #{id})")
    List<Role> findUserByIdAndAllRole(Integer id);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") Integer userId, @Param("roleId") Integer roleId);
}

