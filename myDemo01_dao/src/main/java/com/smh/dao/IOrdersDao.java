package com.smh.dao;

import com.smh.domain.Member;
import com.smh.domain.Orders;
import com.smh.domain.Product;
import com.smh.domain.Traveller;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrdersDao {
    /**查询所有订单
     * @param
     * @return: java.util.List<com.smh.domain.Orders>
     */
    @Select("select * from orders")
    @Results(id = "ordersMap", value={
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum" ,property = "orderNum"),
            @Result(column = "orderTime" ,property = "orderTime"),
            @Result(column = "peopleCount" ,property = "peopleCount"),
            @Result(column = "orderDesc" ,property = "orderDesc"),
            @Result(column = "payType" ,property = "payType"),
            @Result(column = "orderStatus" ,property = "orderStatus"),
            @Result(column = "productid" ,property = "product", javaType = Product.class, one = @One(select = "com.smh.dao.IProductDao.findById")),
            @Result(column = "memberid" ,property = "member", javaType = Member.class, one = @One(select = "com.smh.dao.IMemberDao.findById")),
            @Result(column = "id" ,property = "travellers", javaType = List.class,many = @Many(select = "com.smh.dao.ITravellerDao.findByOrderId"))

    })
    List<Orders> findAll();
    /**根据id查询订单信息
     * @param id
     * @return: com.smh.domain.Orders
     */
    @Select("select * from orders where id = #{id}")
    @ResultMap("ordersMap")
    Orders findById(Integer id);
}
