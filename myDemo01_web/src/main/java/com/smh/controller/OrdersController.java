package com.smh.controller;

import com.github.pagehelper.PageInfo;
import com.smh.domain.Orders;
import com.smh.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;


/**
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/20 0:17
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    IOrdersService iOrdersService;
    //没有进行分页的findAll
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll(){
//        ModelAndView mv = new ModelAndView();
//        List<Orders> ordersList = iOrdersService.findAll();
//        mv.addObject("ordersList",ordersList);
//        mv.setViewName("orders-list");
//        return mv;
//    }
    //@RolesAllowed("ROLE_ADMIN")
    @Secured("ROLE_ADMIN")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page",required = true,defaultValue = "1")Integer page,@RequestParam(name="size",required = true,defaultValue = "4")Integer size){
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = iOrdersService.findAll(page,size);
        //相当于分页bean（它的list属性即为当前页的内容）
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id") Integer id){
        ModelAndView mv = new ModelAndView();
        Orders orders = iOrdersService.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
