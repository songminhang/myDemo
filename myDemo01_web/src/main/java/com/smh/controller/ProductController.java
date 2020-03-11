package com.smh.controller;

import com.smh.domain.Product;
import com.smh.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/18 10:42
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    /**查询所有
     * @param
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> productList = iProductService.findAll();
        mv.addObject("productList",productList);
        mv.setViewName("product-list");
        return mv;
    }
    /**新建产品
     * @param product
     * @return: java.lang.String
     */
    @RequestMapping("/save.do")
    public String save( Product product){
        iProductService.save(product);
        return "redirect:findAll.do";
    }

}
