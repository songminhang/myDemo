package com.smh.controller;

import com.smh.domain.Role;
import com.smh.domain.UserInfo;
import com.smh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/22 10:36
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iUserService;


    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = iUserService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo){
        iUserService.save(userInfo);
        return "redirect:/user/findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam("id") Integer id){
        ModelAndView mv = new ModelAndView();
        UserInfo user = iUserService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }
    /**查询用户以及用户可以添加的角色
     * @param id
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam("id") Integer id){
        ModelAndView mv = new ModelAndView();
        List<Role> otherRoleList = iUserService.findUserByIdAndAllRole(id);
        mv.addObject("user1",iUserService.findById(id));
        mv.addObject("otherRoleList",otherRoleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**把用户和角色的id加入到角色用户关联表中，完成对用户的角色添加
     * @param userId
     * @param roleId
     * @return: java.lang.String
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam("userId") Integer userId,@RequestParam("ids") Integer[] roleIds){
        iUserService.addRoleToUser(userId,roleIds);
        return "redirect:/user/findAll.do";
    }
}
