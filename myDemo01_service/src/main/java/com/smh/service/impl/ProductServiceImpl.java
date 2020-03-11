package com.smh.service.impl;

import com.smh.dao.IProductDao;
import com.smh.domain.Product;
import com.smh.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/17 19:00
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductDao iProductDao;
    @Override
    /** 查询所有
     * @param
     * @return: java.util.List<com.smh.domain.Product>
     */
    public List<Product> findAll() {

      return iProductDao.findAll();

    }
    /**新建产品
     * @param product
     * @return: void
     */
    @Override
    public void save(Product product) {
        iProductDao.save(product);
    }
}
