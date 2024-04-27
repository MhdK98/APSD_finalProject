package miu.edu.cs489.packagetracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Traveler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    @Column(unique = true)
    @JsonIgnore
    private String password;
    private String email;
    private String phone_number;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}
