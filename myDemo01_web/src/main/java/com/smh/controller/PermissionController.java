package com.smh.controller;

import com.smh.dao.IPermissionDao;
import com.smh.domain.Permission;
import com.smh.service.IPermissionService;
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
 * @date ：2020/2/22 16:39
 */
@RequestMapping("/permission")
@Controller
public class PermissionController {
    @Autowired
    IPermissionService iPermissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = iPermissionService.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save( Permission permission){
        iPermissionService.save(permission);
        return "redirect:/permission/findAll.do";
    }

    @RequestMapping("/deleteById.do")
    public String deleteById(@RequestParam("id") Integer id){
        iPermissionService.deleteById(id);
        return "redirect:/permission/findAll.do";
    }
}
