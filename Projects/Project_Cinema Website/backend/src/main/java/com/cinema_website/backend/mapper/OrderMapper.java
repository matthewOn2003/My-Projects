package com.cinema_website.backend.mapper;

import com.cinema_website.backend.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    Order getOrderByOrderId(int orderId);
    List<Order> getOrderByOrderNumber(int orderNumber);
    List<Order> getAllOrders();
    List<Integer> getAllDistinctOrderNumbers();

    Integer getLatestOrderNumber();
    boolean addOrder(Order order);
    boolean updateOrderById(@Param("orderId") int orderId, @Param("order") Order order);
    boolean deleteOrderById(int orderId);
}
