package miu.edu.cs489.packagetracker.service;

import miu.edu.cs489.packagetracker.entity.Traveler;
import miu.edu.cs489.packagetracker.repository.SystemUserDao;
import miu.edu.cs489.packagetracker.repository.TicketDao;
import miu.edu.cs489.packagetracker.repository.TicketStatusDao;
import miu.edu.cs489.packagetracker.entity.Ticket;
import miu.edu.cs489.packagetracker.entity.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketsService {

    SystemUserDao userDao;
    TicketDao ticketDao;
    TicketStatusDao ticketStatusDao;

    @Autowired
    public TicketsService(SystemUserDao userDao, TicketDao ticketDao, TicketStatusDao ticketStatusDao) {
        this.userDao = userDao;
        this.ticketDao = ticketDao;
        this.ticketStatusDao = ticketStatusDao;
    }

    public TicketStatus getTicketStatusById(Integer ticketId){
        Optional<TicketStatus> ticketStatus = ticketStatusDao.findById(ticketId);
        return ticketStatus.orElse(null);
    }

    public void saveTicket(Ticket ticket){
        if(ticket != null){
            ticketDao.save(ticket);
        }
    }

    public void deleteTicket(Integer ticketId){
        Optional<Ticket> ticket = ticketDao.findById(ticketId);
        ticket.ifPresent(value -> ticketDao.delete(value));
    }

    public void addTicketStatus(TicketStatus ticketStatus){
        if(ticketStatus != null){
            ticketStatusDao.save(ticketStatus);
        }
    }

    public List<Ticket> findAllTickets(){
        return (List<Ticket>) ticketDao.findAll();
    }

    public List<Ticket> findAllTicketsByStatus(TicketStatus ticketStatus){
        return ticketDao.findAllByTicketStatus(ticketStatus);
    }

    public void addDummyData() throws Exception {
        // adding Ticket status
        TicketStatus ticketStatus = new TicketStatus();
        ticketStatus.setStatusDesc("Pending");
        TicketStatus ticketStatus2 = new TicketStatus();
        ticketStatus2.setStatusDesc("Found");
        TicketStatus ticketStatus3 = new TicketStatus();
        ticketStatus3.setStatusDesc("Delivered");
        addTicketStatus(ticketStatus);
        addTicketStatus(ticketStatus2);
        addTicketStatus(ticketStatus3);

        // adding Traveler information
        Traveler traveler = new Traveler();
        traveler.setName("Sameer");
        traveler.setUsername("SameerSameer");
        traveler.setPassword("12345");
        traveler.setEmail("samer@demo.com");
        traveler.setTickets(Arrays.asList(
                new Ticket("fd123", "brown leather bag", new Date(), new Date(), ticketStatus),
                new Ticket("tr123", "blue large bag", new Date(), new Date(), ticketStatus2),
                new Ticket("fd123", "silver carry on bag", new Date(), new Date(), ticketStatus3)
        ));
        userDao.save(traveler);

    }

}
