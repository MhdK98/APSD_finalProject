package miu.edu.cs489.packagetracker.controller;

import miu.edu.cs489.packagetracker.entity.Ticket;
import miu.edu.cs489.packagetracker.entity.TicketStatusDesc;
import miu.edu.cs489.packagetracker.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {

    private final TicketsService ticketsService;

    @Autowired
    public TicketController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    @GetMapping("/")
    public List<Ticket> findAllTickets(){
        return ticketsService.findAllTickets();
    }

    @GetMapping("/{ticketId}")
    public Ticket findTicketById(@PathVariable("ticketId") Integer ticketId) throws Exception {
        return ticketsService.findTicketById(ticketId);
    }

    @PostMapping("/")
    public Ticket saveTicket(@RequestBody Ticket ticket) throws Exception {
        return ticketsService.saveTicket(ticket);
    }

    @DeleteMapping("/{ticketId}")
    public String deleteTicket(@PathVariable("ticketId") Integer ticketId){
        ticketsService.deleteTicket(ticketId);
        return "Ticket with ID = " + ticketId + " has been deleted successfully !!";
    }

    @GetMapping("/getAllByStatus/{status}")
    public List<Ticket> findAllTicketsByStatus(@PathVariable("status") TicketStatusDesc ticketStatusDesc){
        return ticketsService.findAllTicketsByStatus(ticketStatusDesc);
    }
}
