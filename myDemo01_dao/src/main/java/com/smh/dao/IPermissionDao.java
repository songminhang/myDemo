package com.smh.dao;

import com.smh.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPermissionDao {

    @Select("select p.* from permission p,role_permission rp where p.id = rp.permissionId and rp.roleId = #{id}")
    List<Permission> findByRoleId(Integer id);


    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);

    @Delete("delete from permission where id = #{id}")
    void deleteById(Integer id);

    @Delete("delete from role_permission where permissionId = #{id}")
    void deleteByIdFromPR(Integer id);
}
