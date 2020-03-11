package com.smh.service.impl;

import com.github.pagehelper.PageHelper;
import com.smh.dao.IOrdersDao;
import com.smh.domain.Orders;
import com.smh.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/20 0:16
 */
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    IOrdersDao iOrdersDao;
    @Override
    public List<Orders> findAll(Integer page,Integer size) {
        //pageNum从那页开始 pageSize每页显示多少条数据
        PageHelper.startPage(page,size);
        return iOrdersDao.findAll();
    }

    @Override
    public Orders findById(Integer id) {
        return iOrdersDao.findById(id);
    }
}
