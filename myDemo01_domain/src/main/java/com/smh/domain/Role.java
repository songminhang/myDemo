package com.smh.domain;





import java.io.Serializable;
import java.util.List;

/**角色实体类
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/20 19:31
 */
public class Role implements Serializable {
    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", permissions=" + permissions +
                ", users=" + users +
                '}';
    }

    private String id; // 主键
    private String roleName; // 角色名
    private String roleDesc; // 角色描述
    private List<Permission> permissions;// 关联的权限集合
    private List<UserInfo> users; // 关联的spring-security角色权限集合

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
}
