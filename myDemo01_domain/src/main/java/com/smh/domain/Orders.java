package com.smh.domain;

import com.smh.utils.DateStrUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**订单实体类
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/19 23:41
 */
public class Orders implements Serializable {
    private Integer id;//无意义主键
    private String orderNum;//订单编号不为空唯一
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date orderTime;//下单时间
    private String orderTimeStr;//代替下单时间方便展示在页面
    private Integer peopleCount;//出行人数
    private String orderDesc;//订单描述
    private Integer payType;//支付方式 0支付宝 1微信 2其他
    private String payTypeStr;//代替支付方式方便展示在页面
    private Integer orderStatus;//订单状态 0未支付 1已支付
    private String orderStatusStr;//代替订单状态方便展示在页面
    private Product product;//关联产品
    private Member member;//关联会员
    private List<Traveller> travellers;//关联旅客

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if(orderTime!=null){
            orderTimeStr = DateStrUtil.date2string(orderTime,"yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        if(payType!=null){
            if(payType==0)payTypeStr = "支付宝";
            else if(payType==1)payTypeStr = "微信";
            else payTypeStr = "其他";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        if(orderStatus!=null){
            if(orderStatus==0)orderStatusStr = "未支付";
            else orderStatusStr = "已支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }
}
