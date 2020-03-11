package com.smh.controller;

import com.github.pagehelper.PageInfo;
import com.smh.domain.SysLog;
import com.smh.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/23 19:17
 */
@Controller
@RequestMapping("sysLog")
public class SysLogController {
    @Autowired
    ISysLogService iSysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page",required = true,defaultValue = "1")Integer page, @RequestParam(name="size",required = true,defaultValue = "8")Integer size){
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogList = iSysLogService.findAll(page,size);
        PageInfo sysLogs = new PageInfo(sysLogList);
        mv.addObject("sysLogs",sysLogs);
        mv.setViewName("syslog-list");
        return mv;
    }
}
