package com.smh.domain;

import java.io.Serializable;

/**旅客实体类
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/19 23:56
 */
public class Traveller implements Serializable {
    private Integer id; //主键
    private String name;//姓名
    private String sex;//性别
    private String phoneNum;//电话号码
    private Integer credentialsType;//证件类型0身份证1护照2军官证
    private String credentialsTypeStr;//代替证件类型方便在页面上展示
    private String credentialsNum;//证件号码
    private Integer travellerType;//旅客类型0成人1儿童
    private String travellerTypeStr;//代替旅客类型方便在页面上展示

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        if(credentialsType!=null){
            if(credentialsType==0)credentialsTypeStr = "身份证";
            else if(credentialsType==1)credentialsTypeStr = "护照";
            else credentialsTypeStr = "军官证";
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        if(travellerType!=null){
            if(travellerType==0)travellerTypeStr = "成人";
            else travellerTypeStr = "儿童";
        }
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}
