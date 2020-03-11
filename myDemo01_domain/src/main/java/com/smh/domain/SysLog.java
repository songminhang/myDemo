package com.smh.domain;

import com.smh.utils.DateStrUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/**
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/23 15:46
 */
public class SysLog implements Serializable {
    private Integer id;//主键
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date visitTime;//访问时间
    private String visitTimeStr;//代替访问时间展示在页面上
    private String username;//操作者用户名
    private String ip;// 访问ip
    private String url;//访问资源url
    private Long executionTime;//执行时长
    private String method;//访问方法

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitTimeStr() {
        if(visitTime!=null){
            visitTimeStr = DateStrUtil.date2string(visitTime,"yyyy-MM-dd HH:mm");
        }
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
