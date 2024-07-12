package com.cinema_website.backend.util;

import com.cinema_website.backend.dto.FoodDTO;
import com.cinema_website.backend.dto.OrderDTO;
import com.cinema_website.backend.dto.SeatDTO;
import com.cinema_website.backend.model.Food;
import com.cinema_website.backend.model.Order;
import com.cinema_website.backend.repository.FoodRepository;
import com.cinema_website.backend.service.FoodService;
import com.cinema_website.backend.service.SeatService;
import org.aspectj.apache.bcel.Repository;
import org.aspectj.weaver.ast.Or;
import org.aspectj.weaver.patterns.ReferencePointcut;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderUtils {

    // Convert Strings to Timestamps
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static OrderDTO toOrderDTO(List<Order> orders, FoodService foodService, SeatService seatService) {
        OrderDTO orderDTO = new OrderDTO();
        Order firstOrder = orders.get(0);

        //
        orderDTO.setOrderNumber(orders.get(0).getOrderNumber());
        orderDTO.setUserId(orders.get(0).getUserId());
        orderDTO.setShowtimeId(orders.get(0).getShowtimeId());

        
        // Initialize empty lists for foods and seats
        BigDecimal totalAmount = BigDecimal.ZERO;
        List<FoodDTO> foodDTOs = new ArrayList<>();
        List<SeatDTO> seatDTOs = new ArrayList<>();
        for (Order order : orders) {
            totalAmount = totalAmount.add(order.getTotalAmount());
            if (order.getFoodId() != 0) {
                FoodDTO food = foodService.getFood(order.getFoodId());
                foodDTOs.add(food);
            }
            if (order.getSeatId() != 0) {
                SeatDTO seat = seatService.getSeat(order.getSeatId());
                seatDTOs.add(seat);
            }
        }
        
        //
        orderDTO.setTotalAmount(totalAmount.toString()); // Assuming totalAmount is a String
        orderDTO.setFoods(foodDTOs);
        orderDTO.setSeats(seatDTOs);


        if (firstOrder.getTransactionDate() != null) {
            orderDTO.setTransactionDate(orders.get(0).getTransactionDate().toString()); // Assuming transactionDate is a String
        }
        if (firstOrder.getCreatedAt() != null) {
            orderDTO.setCreatedAt(firstOrder.getCreatedAt().toString()); // Assuming createdAt is a String
        }
        if (firstOrder.getUpdatedAt() != null) {
            orderDTO.setUpdatedAt(firstOrder.getUpdatedAt().toString()); // Assuming updatedAt is a String
        }

        return orderDTO;
    }

    public static List<Order> toOrders(OrderDTO orderDTO) {
        List<Order> orders = new ArrayList<>();

        // Create orders for foods
        for (FoodDTO food : orderDTO.getFoods()) {
            Order order = new Order();
            order.setOrderNumber(orderDTO.getOrderNumber());
            order.setUserId(orderDTO.getUserId());
            order.setShowtimeId(orderDTO.getShowtimeId());
            order.setTotalAmount(new java.math.BigDecimal(food.getPrice()));
            order.setFoodId(food.getFoodId());
            order.setSeatId(0); // No seat for this order

            try {
                if (orderDTO.getTransactionDate() != null) {
                    order.setTransactionDate(Timestamp.valueOf(orderDTO.getTransactionDate()));
                }
                if (orderDTO.getCreatedAt() != null) {
                    order.setCreatedAt(Timestamp.valueOf(orderDTO.getCreatedAt()));
                }
                if (orderDTO.getUpdatedAt() != null) {
                    order.setUpdatedAt(Timestamp.valueOf(orderDTO.getUpdatedAt()));
                }
            } catch (Exception e) {
                e.printStackTrace(); // Handle the exception properly in real scenarios
            }

            orders.add(order);
        }

        // Create orders for seats
        for (SeatDTO seat : orderDTO.getSeats()) {
            Order order = new Order();
            order.setOrderNumber(orderDTO.getOrderNumber());
            order.setUserId(orderDTO.getUserId());
            order.setShowtimeId(orderDTO.getShowtimeId());
            order.setTotalAmount(new java.math.BigDecimal(seat.getPrice()));
            order.setFoodId(0); // No food for this order
            order.setSeatId(seat.getSeatId());

            try {
                if (orderDTO.getTransactionDate() != null) {
                    order.setTransactionDate(Timestamp.valueOf(orderDTO.getTransactionDate()));
                }
                if (orderDTO.getCreatedAt() != null) {
                    order.setCreatedAt(Timestamp.valueOf(orderDTO.getCreatedAt()));
                }
                if (orderDTO.getUpdatedAt() != null) {
                    order.setUpdatedAt(Timestamp.valueOf(orderDTO.getUpdatedAt()));
                }
            } catch (Exception e) {
                e.printStackTrace(); // Handle the exception properly in real scenarios
            }

            orders.add(order);
        }

        return orders;
    }


}
