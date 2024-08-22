package com.cinema_website.backend.repository;

import com.cinema_website.backend.dto.FoodDTO;
import com.cinema_website.backend.dto.OrderDTO;
import com.cinema_website.backend.dto.SeatDTO;
import com.cinema_website.backend.dto.TicketDTO;
import com.cinema_website.backend.mapper.TicketMapper;
import com.cinema_website.backend.model.Food;
import com.cinema_website.backend.model.Order;
import com.cinema_website.backend.model.Ticket;
import com.cinema_website.backend.service.OrderService;
import com.cinema_website.backend.service.ShowtimeService;
import com.cinema_website.backend.util.OrderUtils;
import com.cinema_website.backend.util.TicketUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TicketRepository {

    private final TicketMapper ticketMapper;
    private final OrderService orderService;
    private final ShowtimeService showtimeService;

    @Autowired
    public TicketRepository(TicketMapper ticketMapper, OrderService orderService, ShowtimeService showtimeService) {
        this.ticketMapper = ticketMapper;
        this.orderService = orderService;
        this.showtimeService = showtimeService;
    }

    public TicketDTO getTicketById(int ticketId) {
        Ticket ticket = ticketMapper.getTicketById(ticketId);
        return TicketUtils.toTicketDTO(ticket, orderService, showtimeService);
    }

    // Extra function
    public String getTicketSummaryById(int ticketId) {
        TicketDTO ticketDTO = getTicketById(ticketId);

        Map<String, Object> ticketDetails = new HashMap<>();
        ticketDetails.put("ticketId", ticketDTO.getTicketId());
        ticketDetails.put("orderNumber", ticketDTO.getOrder().getOrderNumber());
        ticketDetails.put("movieTitle", ticketDTO.getMovieTitle());
        ticketDetails.put("hallName", ticketDTO.getHallName());
        ticketDetails.put("cinemaName", ticketDTO.getCinemaName());

        StringBuilder foodNumbers = new StringBuilder();
        StringBuilder seatNumbers = new StringBuilder();

        for (FoodDTO foodDTO : ticketDTO.getOrder().getFoods()) {
            if (foodNumbers.length() > 0) {
                foodNumbers.append(", ");
            }
            foodNumbers.append(foodDTO.getFoodNumber());
        }

        for (SeatDTO seatDTO : ticketDTO.getOrder().getSeats()) {
            if (seatNumbers.length() > 0) {
                seatNumbers.append(", ");
            }
            seatNumbers.append(seatDTO.getSeatNumber());
        }

        ticketDetails.put("foodNumbers", foodNumbers.toString());
        ticketDetails.put("seatNumbers", seatNumbers.toString());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(ticketDetails);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }
    public TicketDTO getTicketByReferenceNo(int referenceNo) {
        Ticket ticket = ticketMapper.getTicketByReferenceNo(referenceNo);
        return TicketUtils.toTicketDTO(ticket, orderService, showtimeService);
    }

    public List<TicketDTO> getAllTickets() {

        List<TicketDTO> ticketDTOs = new ArrayList<>();
        List<Ticket> tickets = ticketMapper.getAllTickets();

        for (Ticket ticket : tickets) {
            TicketDTO ticketDTO = TicketUtils.toTicketDTO(ticket, orderService, showtimeService);

            ticketDTOs.add(ticketDTO);
        }

        return ticketDTOs;
    }


    public List<TicketDTO> getTicketsByUserId(int userId) {

        List<TicketDTO> ticketDTOs = new ArrayList<>();
        List<Ticket> tickets = ticketMapper.getTicketsByUserId(userId);

        for (Ticket ticket : tickets) {
            TicketDTO ticketDTO = TicketUtils.toTicketDTO(ticket, orderService, showtimeService);

            ticketDTOs.add(ticketDTO);
        }

        return ticketDTOs;
    }

    public boolean addTicket(TicketDTO ticketDTO) {
        try {
            Ticket ticket = TicketUtils.toTicket(ticketDTO, orderService);
            return ticketMapper.addTicket(ticket);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicates insertion failure
        }
    }

    public boolean updateTicketById(int ticketId, TicketDTO updatedTicketDTO) {
        try {
            Ticket updatedTicket = TicketUtils.toTicket(updatedTicketDTO, orderService);
            return ticketMapper.updateTicketById(ticketId, updatedTicket);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicates update failure
        }
    }

    public boolean updateTicketByReferenceNo(int referenceNo, TicketDTO updatedTicketDTO) {
        try {
            Ticket updatedTicket = TicketUtils.toTicket(updatedTicketDTO, orderService);
            return ticketMapper.updateTicketByReferenceNo(referenceNo, updatedTicket);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicates update failure
        }
    }

    public boolean deleteTicketById(int ticketId) {
        try {
            return ticketMapper.deleteTicketById(ticketId);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicates deletion failure
        }
    }

    public boolean deleteTicketByReferenceNo(int referenceNo) {
        try {
            return ticketMapper.deleteTicketByReferenceNo(referenceNo);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicates deletion failure
        }
    }
}
