package com.example.provider01.service.impl;

import com.example.provider01.repository.dao.OrderDao;
import com.example.provider01.service.OrderService;
import common.domain.Order;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/7 14:01
 */
@Service
public class OrderServieceImpl implements OrderService {

    @Resource
    private OrderDao dao;

    @Override
    public Order findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return dao.findAll();
    }
}
