package com.cinema_website.backend.service;

import com.cinema_website.backend.dto.OrderDTO;
import com.cinema_website.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // GET
//    public OrderDTO getOrder(int orderId) {
//        return orderRepository.getOrderByOrderId(orderId);
//    }

    public synchronized OrderDTO getOrderByOrderNumber(int orderNumber) {
        return orderRepository.getOrderByOrderNumber(orderNumber);
    }

    public synchronized List<OrderDTO> getAllOrders() {
        return orderRepository.getAllOrders();
    }


    // INSERT
    public synchronized boolean addOrder(OrderDTO order) {
        return orderRepository.addOrder(order);
    }


}
