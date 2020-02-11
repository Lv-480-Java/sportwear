package com.sportwear.service;

import com.sportwear.dao.OrderDao;
import com.sportwear.entity.Order;

import java.util.List;
import java.util.logging.Logger;

public class OrderService {
    private static Logger logger = Logger.getLogger(OrderService.class.getName());
    private OrderDao orderDao = new OrderDao();

    public void add(Order order) {
        orderDao.create(order);
    }

    public List<Order> getAllOrder() {
        return orderDao.readAll();
    }

    public Order getOneOrder(Long id) {
        return orderDao.readById(id);
    }

    public void update(Order order, Long id) {
        orderDao.update(order, id);
    }

    public void remove(Long id) {
        orderDao.delete(id);
    }
}
