package miu.edu.cs489.packagetracker.controller;


import miu.edu.cs489.packagetracker.entity.Ticket;
import miu.edu.cs489.packagetracker.entity.TicketStatus;
import miu.edu.cs489.packagetracker.entity.Traveler;
import miu.edu.cs489.packagetracker.service.TicketsService;
import miu.edu.cs489.packagetracker.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class SimpleCRUD {

    UsersService usersService;
    TicketsService ticketsService;

    @Autowired
    public SimpleCRUD(UsersService usersService, TicketsService ticketsService) throws Exception {
        this.usersService = usersService;
        this.ticketsService = ticketsService;
    }

    @GetMapping("/init")
    public List<Ticket> CRUD_OPS() throws Exception {
        // create dummy data
        ticketsService.addDummyData();

        // print available tickets
        List<Ticket> tickets = ticketsService.findAllTickets();
        tickets.forEach(System.out::println);

        // update a ticket
        Ticket ticket = tickets.get(0);
//        ticket.setTicketStatus(ticketsService.getTicketStatusById(2));
        ticket.setCloseCase_date(new Date());
        ticketsService.saveTicket(ticket);

        // delete a ticket
        ticketsService.deleteTicket(3);

        // Read remaining data
        tickets = ticketsService.findAllTickets();
        return tickets;
    }

}
