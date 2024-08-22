package com.cinema_website.backend.controller;

import com.cinema_website.backend.dto.TicketDTO;
import com.cinema_website.backend.service.TicketService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("all")
@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final ObjectMapper objectMapper;
    private final TicketService ticketService;

    @Autowired
    public TicketController(ObjectMapper objectMapper, TicketService ticketService) {
        this.objectMapper = objectMapper;
        this.ticketService = ticketService;
    }

    // GET
    @GetMapping("/getTicket/{ticketId}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable int ticketId) {
        TicketDTO ticket = ticketService.getTicketById(ticketId);
        if (ticket != null) {
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getTicketSummary/{ticketId}")
    public String getTicketSummaryById(@PathVariable int ticketId) {
        String summary = ticketService.getTicketSummaryById(ticketId);
        return summary;
    }

    @GetMapping("/getTicketByReferenceNo/{referenceNo}")
    public ResponseEntity<TicketDTO> getTicketByReferenceNo(@PathVariable int referenceNo) {
        TicketDTO ticket = ticketService.getTicketByReferenceNo(referenceNo);
        if (ticket != null) {
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllTickets")
    public ResponseEntity<List<TicketDTO>> getAllTickets() {
        List<TicketDTO> ticketList = ticketService.getAllTickets();
        if (ticketList != null && !ticketList.isEmpty()) {
            return new ResponseEntity<>(ticketList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

        @GetMapping("/getTicketsByUserId/{userId}")
    public ResponseEntity<List<TicketDTO>> getTicketsByUserId(@PathVariable int userId) {
        List<TicketDTO> ticketList = ticketService.getTicketsByUserId(userId);
        if (ticketList != null && !ticketList.isEmpty()) {
            return new ResponseEntity<>(ticketList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // POST
    @PostMapping("/addTicket")
    public ResponseEntity<Boolean> addTicket(@RequestBody TicketDTO ticket) {
        boolean result = ticketService.addTicket(ticket);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    // PUT
    @PutMapping("/updateTicketById/{ticketId}")
    public ResponseEntity<Boolean> updateTicketById(@PathVariable int ticketId, @RequestBody TicketDTO updatedTicket) {
        boolean result = ticketService.updateTicketById(ticketId, updatedTicket);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateTicketByReferenceNo/{referenceNo}")
    public ResponseEntity<Boolean> updateTicketByReferenceNo(@PathVariable int referenceNo, @RequestBody TicketDTO updatedTicket) {
        boolean result = ticketService.updateTicketByReferenceNo(referenceNo, updatedTicket);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/deleteTicketById/{ticketId}")
    public ResponseEntity<Boolean> deleteTicketById(@PathVariable int ticketId) {
        boolean result = ticketService.deleteTicketById(ticketId);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteTicketByReferenceNo/{referenceNo}")
    public ResponseEntity<Boolean> deleteTicketByReferenceNo(@PathVariable int referenceNo) {
        boolean result = ticketService.deleteTicketByReferenceNo(referenceNo);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
