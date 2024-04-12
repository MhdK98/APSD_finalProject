package miu.edu.cs489.packagetracker.repository;

import miu.edu.cs489.packagetracker.entity.TicketStatus;
import org.springframework.data.repository.CrudRepository;

public interface TicketStatusDao extends CrudRepository<TicketStatus, Integer> {
}
