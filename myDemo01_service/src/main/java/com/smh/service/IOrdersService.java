package com.smh.service;

import com.smh.domain.Orders;

import java.util.List;

public interface IOrdersService {
    /**查询所有订单
     * @param
     * @return: java.util.List<com.smh.domain.Orders>
     */
    List<Orders> findAll(Integer page,Integer size);
    /**根据id查询订单
     * @param id
     * @return: com.smh.domain.Orders
     */
    Orders findById(Integer id);
}
