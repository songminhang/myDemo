package com.smh.dao;


import com.smh.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITravellerDao {
    /**根据id查询旅客信息
     * @param id
     * @return: com.smh.domain.Traveller
     */
    @Select("select * from traveller where id = #{id}")
    Traveller findById(Integer id);
    /**根据orderId查询旅客信息
     * @param id
     * @return: com.smh.domain.Traveller
     */
    @Select("select t.* from traveller t,order_traveller ot where t.id = ot.travellerId and ot.orderId = #{id}")
    List<Traveller> findByOrderId(Integer id);
}
