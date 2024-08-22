package com.cinema_website.backend.service;

import com.cinema_website.backend.dto.TicketDTO;
import com.cinema_website.backend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("all")
@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // GET
    public TicketDTO getTicketById(int ticketId) {
        return ticketRepository.getTicketById(ticketId);
    }

    public String getTicketSummaryById(int ticketId) {
        return ticketRepository.getTicketSummaryById(ticketId);
    }

    public TicketDTO getTicketByReferenceNo(int referenceNo) {
        return ticketRepository.getTicketByReferenceNo(referenceNo);
    }

    public List<TicketDTO> getAllTickets() {
        return ticketRepository.getAllTickets();
    }

    public List<TicketDTO> getTicketsByUserId(int userId) {
        return ticketRepository.getTicketsByUserId(userId);
    }

    // INSERT
    public boolean addTicket(TicketDTO ticketDTO) {
        return ticketRepository.addTicket(ticketDTO);
    }

    // UPDATE
    public boolean updateTicketById(int ticketId, TicketDTO updatedTicketDTO) {
        return ticketRepository.updateTicketById(ticketId, updatedTicketDTO);
    }

    public boolean updateTicketByReferenceNo(int referenceNo, TicketDTO updatedTicketDTO) {
        return ticketRepository.updateTicketByReferenceNo(referenceNo, updatedTicketDTO);
    }

    // DELETE
    public boolean deleteTicketById(int ticketId) {
        return ticketRepository.deleteTicketById(ticketId);
    }

    public boolean deleteTicketByReferenceNo(int referenceNo) {
        return ticketRepository.deleteTicketByReferenceNo(referenceNo);
    }
}
