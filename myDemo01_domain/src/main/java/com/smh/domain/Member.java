package com.smh.domain;

import java.io.Serializable;

/**会员实体类
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/19 23:54
 */
public class Member implements Serializable {
    private Integer id;//主键
    private String name;//姓名
    private String nickName;//昵称
    private String phoneNum;//电话号码
    private String email;//邮箱

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickname) {
        this.nickName = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
