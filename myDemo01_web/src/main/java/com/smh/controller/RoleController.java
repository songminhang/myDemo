package com.smh.controller;

import com.smh.domain.Permission;
import com.smh.domain.Role;
import com.smh.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

/**
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/22 14:04
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    IRoleService iRoleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = iRoleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save( Role role){
        iRoleService.save(role);
        return "redirect:/role/findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam("id") Integer id){
        ModelAndView mv = new ModelAndView();
        Role role = iRoleService.findById(id);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }
    @RequestMapping("/deleteById.do")
    public String delete(@RequestParam("id") Integer id){
        iRoleService.deleteById(id);
        return "redirect:/role/findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(Integer id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("role1",iRoleService.findById(id));
        List<Permission> otherPermissionList = iRoleService.findRoleByIdAndAllPermission(id);
        mv.addObject("otherPermissionList",otherPermissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }


    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam("roleId") Integer roleId,@RequestParam("ids") Integer[] permissionIds){
        iRoleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:/role/findAll.do";
    }
}
