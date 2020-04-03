package com.example.provider03.repository.dao;

import common.domain.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/7 13:51
 */

public interface OrderDao {

    @Select("select * from cloud_order where id = #{id}")
    Order findById(Long id);

    @Select("select * from cloud_order")
    List<Order> findAll();

}
