package com.example.provider03.service;

import common.domain.Order;

import java.util.List;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/7 14:00
 */
public interface OrderService {

    Order findById(Long id);

    List<Order> findAll();
}
