package com.cinema_website.backend.repository;

import com.cinema_website.backend.dto.OrderDTO;
import com.cinema_website.backend.dto.SeatDTO;
import com.cinema_website.backend.dto.TicketDTO;
import com.cinema_website.backend.mapper.*;
import com.cinema_website.backend.model.*;
import com.cinema_website.backend.service.*;
import com.cinema_website.backend.util.OrderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private final OrderMapper orderMapper;
    private final TicketMapper ticketMapper;
    private final ShowtimeMapper showtimeMapper;
    private final HallMapper hallMapper;
    private final MovieMapper movieMapper;
    private final CinemaMapper cinemaMapper;

    private final FoodService foodService;
    private final SeatService seatService;

    // use order to retrieve foods and seats
    // use ticket to retrieve cinema, hall, movie name

    @Autowired
    public OrderRepository(OrderMapper orderMapper, TicketMapper ticketMapper, ShowtimeMapper showtimeMapper,
                           HallMapper hallMapper, MovieMapper movieMapper, CinemaMapper cinemaMapper,
                           FoodService foodService, SeatService seatService) {
        this.orderMapper = orderMapper;
        this.ticketMapper = ticketMapper;
        this.showtimeMapper = showtimeMapper;
        this.hallMapper = hallMapper;
        this.movieMapper = movieMapper;
        this.cinemaMapper = cinemaMapper;
        this.foodService = foodService;
        this.seatService = seatService;
    }


    public OrderDTO getOrderByOrderNumber(int orderNumber) {
        List<Order> orders = orderMapper.getOrderByOrderNumber(orderNumber);
        return OrderUtils.toOrderDTO(orders, foodService, seatService);
    }

    public List<OrderDTO> getAllOrders() {

        List<OrderDTO> orderDTOS = new ArrayList<>();
        List<Integer> orderNumbers = orderMapper.getAllDistinctOrderNumbers();

        for (Integer orderNumber : orderNumbers) {
            List<Order> orders = orderMapper.getOrderByOrderNumber(orderNumber);
            OrderDTO orderDTO = OrderUtils.toOrderDTO(orders, foodService, seatService);

            orderDTOS.add(orderDTO);
        }

        return orderDTOS;
    }

    public Integer getLatestOrderNumber() {
        return orderMapper.getLatestOrderNumber();
    }

    // INSERT
    public boolean addOrder(OrderDTO orderDTO) {
        try {
            List<Order> orders = OrderUtils.toOrders(orderDTO);
            Integer orderNumber = (getLatestOrderNumber() != null ? getLatestOrderNumber() + 1 : 1001);

            for (Order order : orders) {
                order.setOrderNumber(orderNumber);
                orderMapper.addOrder(order);
            }

            // add ticket also
            int showtimeId = orders.get(0).getShowtimeId();
            Showtime showtime = showtimeMapper.getShowtimeById(showtimeId);
            Hall hall = hallMapper.getHallById(showtime.getHallId());
            Movie movie = movieMapper.getMovieById(showtime.getMovieId());
            Cinema cinema = cinemaMapper.getCinemaById(showtime.getCinemaId());

            Ticket ticket = new Ticket();
            ticket.setReferenceNo(orderNumber);
            ticket.setHallName(hall.getHallName());
            ticket.setMovieTitle(movie.getTitle());
            ticket.setCinemaName(cinema.getName());
            ticketMapper.addTicket(ticket);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicates insertion failure
        }
    }

    // UPDATE
//    public boolean updateOrderById(int orderId, OrderDTO updatedOrder) {
//        try {
//            Order order = OrderUtils.toOrder(updatedOrder);
//            return orderMapper.updateOrderById(orderId, order);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false; // Return false indicates update failure
//        }
//    }

    // DELETE
//    public boolean deleteOrderById(int orderId) {
//        try {
//            return orderMapper.deleteOrderById(orderId);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false; // Return false indicates deletion failure
//        }
//    }
}
