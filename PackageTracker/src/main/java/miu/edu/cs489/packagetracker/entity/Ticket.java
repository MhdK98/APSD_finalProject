package miu.edu.cs489.packagetracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private String flight_number;
    private String bagsDesc;
    private Date submit_date;
    private Date closeCase_date;
    @Column(nullable = false)
    private TicketStatusDesc ticketStatus;

    public Ticket(String flight_number,  String bagsDesc, Date submit_date, TicketStatusDesc ticketStatus) {
        this.flight_number = flight_number;
        this.bagsDesc = bagsDesc;
        this.submit_date = submit_date;
        this.ticketStatus = ticketStatus;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", flight_number='" + flight_number + '\'' +
                ", bagsDesc='" + bagsDesc + '\'' +
                ", submit_date=" + submit_date +
                ", ticketStatus=" + ticketStatus +
                '}';
    }
}
