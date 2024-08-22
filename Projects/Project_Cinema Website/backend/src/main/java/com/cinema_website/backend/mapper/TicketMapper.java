package com.cinema_website.backend.mapper;

import com.cinema_website.backend.model.Ticket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TicketMapper {

    Ticket getTicketById(@Param("ticketId") int ticketId);

    Ticket getTicketByReferenceNo(@Param("referenceNo") int referenceNo);

    List<Ticket> getAllTickets();

    List<Ticket> getTicketsByUserId(int userId);

    boolean addTicket(Ticket ticket);

    boolean updateTicketById(@Param("ticketId") int ticketId, @Param("ticket") Ticket ticket);

    boolean updateTicketByReferenceNo(@Param("referenceNo") int referenceNo, @Param("ticket") Ticket ticket);

    boolean deleteTicketById(@Param("ticketId") int ticketId);

    boolean deleteTicketByReferenceNo(@Param("referenceNo") int referenceNo);
}
