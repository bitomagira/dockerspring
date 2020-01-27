package com.example.demo.ticket;

import com.example.demo.user.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketModel {
    @Id
    private int id;
    private int amount;
    @ManyToOne
    @JoinColumn
    private User personPaying;
    @ManyToOne
    @JoinColumn
    private User personReceiving;

}
