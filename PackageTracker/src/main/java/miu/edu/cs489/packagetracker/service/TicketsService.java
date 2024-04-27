package miu.edu.cs489.packagetracker.service;

import miu.edu.cs489.packagetracker.entity.TicketStatusDesc;
import miu.edu.cs489.packagetracker.entity.Traveler;
import miu.edu.cs489.packagetracker.repository.TicketRepo;
import miu.edu.cs489.packagetracker.entity.Ticket;
import miu.edu.cs489.packagetracker.repository.TravelerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketsService implements ApplicationRunner {

    TravelerRepo travelerRepo;
    TicketRepo ticketRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public TicketsService(TravelerRepo travelerRepo, TicketRepo ticketRepo, BCryptPasswordEncoder passwordEncoder) {
        this.travelerRepo = travelerRepo;
        this.ticketRepo = ticketRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Ticket saveTicket(Ticket ticket) throws Exception {
        Ticket temp = ticketRepo.findById(ticket.getTicketId()).get();
        temp.setTicketStatus(ticket.getTicketStatus());
        temp.setCloseCase_date(ticket.getCloseCase_date());
        temp.setSubmit_date(ticket.getSubmit_date());
        temp.setFlight_number(ticket.getFlight_number());
        temp.setBagsDesc(ticket.getBagsDesc());
        return ticketRepo.save(ticket);
    }

    public void deleteTicket(Integer ticketId){
        Optional<Ticket> ticket = ticketRepo.findById(ticketId);
        ticket.ifPresent(value -> {
            value.setTicketStatus(TicketStatusDesc.Deleted);
            ticketRepo.save(value);
        });
    }

    public List<Ticket> findAllTickets(){
        return ticketRepo.findTicketsNotDeleted(TicketStatusDesc.Deleted);
    }

    public Ticket findTicketById(Integer ticketId) throws Exception {
        Optional<Ticket> ticketOptional = ticketRepo.findById(ticketId);
        if(ticketOptional.isPresent()){
            return ticketOptional.get();
        }
        throw new Exception("Ticket Not Found with id = "+ticketId);
    }

    public List<Ticket> findAllTicketsByStatus(TicketStatusDesc TicketStatusDesc){
        return ticketRepo.findAllByTicketStatus(TicketStatusDesc);
    }

    public void addDummyData() throws Exception {
        // adding Traveler information
        Traveler traveler = new Traveler();
        traveler.setName("Sameer");
        traveler.setPassword(passwordEncoder.encode("12345"));
        traveler.setEmail("samer@demo.com");
        traveler.setTickets(Arrays.asList(
                new Ticket("fd123", "brown leather bag", new Date(), TicketStatusDesc.Pending),
                new Ticket("tr123", "blue large bag", new Date(), TicketStatusDesc.Found),
                new Ticket("fd123", "silver carry on bag", new Date(), TicketStatusDesc.Delivered)
        ));
        travelerRepo.save(traveler);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        addDummyData();
    }
}
