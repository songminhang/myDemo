package com.smh.dao;

import com.smh.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberDao {
    /**根据id查询会员
     * @param id
     * @return: com.smh.domain.Member
     */
    @Select("select * from member where id = #{id}")
    Member findById(Integer id);
}
