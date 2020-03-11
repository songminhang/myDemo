package com.smh.service;

import com.smh.domain.Product;

import java.util.List;

public interface IProductService {
    /**查询所有
     * @param
     * @return: java.util.List<com.smh.domain.Product>
     */
    List<Product> findAll();
    /**新建产品
     * @param product
     * @return: void
     */
    void save(Product product);
}
