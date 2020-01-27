package com.example.demo.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService myTicketService;

    @RequestMapping("")
    public List<TicketModel> getAllTickets(){
        return myTicketService.getAllTickets();
    }

    @RequestMapping(method = RequestMethod.POST,value = "", consumes ="application/json",produces = "application/json")
    public TicketModel createTicket(@RequestBody TicketModel ticket){
        return myTicketService.createTicket(ticket);
    }
}
