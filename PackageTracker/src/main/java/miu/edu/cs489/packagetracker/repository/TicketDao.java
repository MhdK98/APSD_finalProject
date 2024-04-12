package miu.edu.cs489.packagetracker.repository;

import miu.edu.cs489.packagetracker.entity.Ticket;
import miu.edu.cs489.packagetracker.entity.TicketStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketDao extends CrudRepository<Ticket, Integer> {

    public List<Ticket> findAllByTicketStatus(TicketStatus ticketStatus);
}
