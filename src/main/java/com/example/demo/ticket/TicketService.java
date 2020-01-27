package com.example.demo.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository myTicketrepo;

    public List<Ticket> getAllTickets(){
        return myTicketrepo.findAll();
    }

    public Ticket createTicket(Ticket ticket){

        return myTicketrepo.save(ticket);
    }

}
