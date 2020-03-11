package com.smh.controller;

import com.smh.domain.SysLog;
import com.smh.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;
/**
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/23 18:08
 */
@Aspect
@Component
public class LogAop {

    Date visitTime;//访问时间
    Class clazz;//访问的类
    Method method;//执行的方法
    Long executionTime;//执行的时间
    String url;//访问路径
    String ip;//访问ip
    String username;//操作者用户名
    @Autowired
    HttpServletRequest request;//request对象，通过配置监听器自动注入
    @Autowired
    ISysLogService iSysLogService;
    /**
     * 前置通知
     * 获取方法开始时间，执行的类，执行的方法
     * @param joinPoint
     * @return: void
     */
    @Before("execution( * com.smh.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        //获取开始时间
        visitTime = new Date();
        //获取执行的类
        clazz = joinPoint.getTarget().getClass();
        //获取执行的方法名
        String methodName = joinPoint.getSignature().getName();
        //获取执行的方法的参数
        Object[] args = joinPoint.getArgs();
        //若没有参数则直接获取方法
        if(args==null || args.length==0){
            method = clazz.getMethod(methodName);
        }
        //若有参数则需要创建一个方法参数的class数组
        else{
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName,classArgs);
        }
    }

    @After("execution( * com.smh.controller.*.*(..))")
    public void doAfter(){
        //计算总共执行时间
        executionTime = new Date().getTime() - visitTime.getTime();
        //获取url 通过放射注解拼接获得（类的和方法的）
        if(clazz!=null & method!=null & clazz != LogAop.class){
            //获取类url
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if(classAnnotation!=null){
                String[] classValue = classAnnotation.value();
                //获取方法url
                RequestMapping methodAnnotation = (RequestMapping) method.getAnnotation(RequestMapping.class);
                if(methodAnnotation!=null){
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];
                }
            }
        }
        //获取访问的ip ，通过request对象 （在web.xml中配置监听器，监听request域对象的创建和销毁的）
        ip = request.getRemoteAddr();

        //获取当前操作者名 通过spring security 框架获取，或者在session域中获取
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        username = user.getUsername();

        //将信息封装到SysLog对象中
        SysLog sysLog = new SysLog();
        sysLog.setExecutionTime(executionTime);
        sysLog.setIp(ip);
        sysLog.setMethod("[类]: "+ clazz.getName() +" [方法]: "+method.getName());
        sysLog.setUrl(url);
        sysLog.setUsername(username);
        sysLog.setVisitTime(visitTime);
        iSysLogService.save(sysLog);
    }
}
