package com.smh.dao;

import com.smh.domain.Permission;
import com.smh.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleDao {
    /**根据角色id查询role
     * @param id
     * @return: java.util.List<com.smh.domain.Role>
     */
    @Select("select r.* from role r,users_role ur where r.id = ur.roleId and ur.userId = #{id}")
    @Results(id = "roleMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = List.class,many = @Many(select = "com.smh.dao.IPermissionDao.findByRoleId"))
    })
    List<Role> findByUserId(Integer id);

    @Select("select * from role")
    @ResultMap("roleMap")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Delete("delete from role where id = #{id}")
    void deleteById(Integer id);

    @Select("select * from role where id = #{id}")
    @ResultMap("roleMap")
    Role findById(Integer id);

    /**删除用户角色表关联
     * @param id
     * @return: void
     */
    @Delete("delete from users_role where roleId = #{id}")
    void deleteByRoleIdFromUR(Integer id);
    /**删除权限角色表关联
     * @param id
     * @return: void
     */
    @Delete("delete from role_permission where roleId = #{id}")
    void deleteByRoleIdFromPR(Integer id);

    @Select("select * from permission where id not in(select id from permission p,role_permission rp where p.id = rp.permissionId and rp.roleId = #{id})")
    List<Permission> findRoleByIdAndAllPermission(Integer id);

    @Insert("insert into role_permission values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId);
}
