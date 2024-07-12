package com.cinema_website.backend.repository;

import com.cinema_website.backend.dto.OrderDTO;
import com.cinema_website.backend.dto.TicketDTO;
import com.cinema_website.backend.mapper.TicketMapper;
import com.cinema_website.backend.model.Order;
import com.cinema_website.backend.model.Ticket;
import com.cinema_website.backend.service.OrderService;
import com.cinema_website.backend.util.OrderUtils;
import com.cinema_website.backend.util.TicketUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketRepository {

    private final TicketMapper ticketMapper;
    private final OrderService orderService;

    @Autowired
    public TicketRepository(TicketMapper ticketMapper, OrderService orderService) {
        this.ticketMapper = ticketMapper;
        this.orderService = orderService;
    }

    public TicketDTO getTicketById(int ticketId) {
        Ticket ticket = ticketMapper.getTicketById(ticketId);
        return TicketUtils.toTicketDTO(ticket, orderService);
    }

    public TicketDTO getTicketByReferenceNo(int referenceNo) {
        Ticket ticket = ticketMapper.getTicketByReferenceNo(referenceNo);
        return TicketUtils.toTicketDTO(ticket, orderService);
    }

    public List<TicketDTO> getAllTickets() {


        List<TicketDTO> ticketDTOs = new ArrayList<>();
        List<Ticket> tickets = ticketMapper.getAllTickets();

        for (Ticket ticket : tickets) {
            TicketDTO ticketDTO = TicketUtils.toTicketDTO(ticket, orderService);

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
