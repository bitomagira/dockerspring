package com.example.demo.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository myTicketrepo;

    public List<TicketModel> getAllTickets(){
        return myTicketrepo.findAll();
    }

    public TicketModel createTicket(TicketModel ticket){

        return myTicketrepo.save(ticket);
    }

}
