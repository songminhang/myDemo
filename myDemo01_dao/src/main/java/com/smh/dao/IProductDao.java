package com.smh.dao;

import com.smh.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface IProductDao {
    /**根据id查询产品
     * @param id
     * @return: com.smh.domain.Product
     */
    @Select("select * from product where id = #{id}")
    Product findById(Integer id);
    /** 查询所有
     * @param
     * @return: java.util.List<com.smh.domain.Product>
     */
    @Select("select * from product")
    List<Product> findAll();

    /**新建产品
     * @param
     * @return: void
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
