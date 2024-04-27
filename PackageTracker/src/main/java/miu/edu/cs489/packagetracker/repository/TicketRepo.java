package miu.edu.cs489.packagetracker.repository;

import miu.edu.cs489.packagetracker.entity.Ticket;
import miu.edu.cs489.packagetracker.entity.TicketStatusDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

    @Query("select t from Ticket t where t.ticketStatus != ?1 ")
    public List<Ticket> findTicketsNotDeleted(TicketStatusDesc ticketStatus);

    public List<Ticket> findAllByTicketStatus(TicketStatusDesc ticketStatus);
}
