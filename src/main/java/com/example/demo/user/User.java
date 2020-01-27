package com.example.demo.user;
import com.example.demo.ticket.TicketModel;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class User {
    @Id
    private int id;
    private String name;
    private String surname;
    private String role;
}
