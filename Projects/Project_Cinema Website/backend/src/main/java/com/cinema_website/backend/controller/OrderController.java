package com.cinema_website.backend.controller;

import com.cinema_website.backend.dto.OrderDTO;
import com.cinema_website.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("all")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // GET
//    @GetMapping("/getOrder/{orderId}")
//    public ResponseEntity<OrderDTO> getOrderById(@PathVariable int orderId) {
//        OrderDTO order = orderService.getOrder(orderId);
//        if (order != null) {
//            return new ResponseEntity<>(order, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping("/getOrderByOrderNumber/{orderNumber}")
    public ResponseEntity<OrderDTO> getOrderByOrderNumber(@PathVariable int orderNumber) {
        OrderDTO orderDTO = orderService.getOrderByOrderNumber(orderNumber);
        if (orderDTO != null) {
            return new ResponseEntity<>(orderDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orderList = orderService.getAllOrders();
        if (orderList != null && !orderList.isEmpty()) {
            return new ResponseEntity<>(orderList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // POST
    @PostMapping("/addOrder")
    public ResponseEntity<Boolean> addOrder(@RequestBody OrderDTO orderDTO) {
        boolean result = orderService.addOrder(orderDTO);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    // PUT
//    @PutMapping("/updateOrder/{orderId}")
//    public ResponseEntity<Boolean> updateOrder(@PathVariable int orderId, @RequestBody OrderDTO updatedOrder) {
//        boolean result = orderService.updateOrder(orderId, updatedOrder);
//        if (result) {
//            return new ResponseEntity<>(true, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
//        }
//    }

    // DELETE
//    @DeleteMapping("/deleteOrder/{orderId}")
//    public ResponseEntity<Boolean> deleteOrder(@PathVariable int orderId) {
//        boolean result = orderService.deleteOrder(orderId);
//        if (result) {
//            return new ResponseEntity<>(true, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
//        }
//    }
}
