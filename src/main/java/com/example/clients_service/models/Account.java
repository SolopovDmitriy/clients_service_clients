package com.example.clients_service.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
//
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double amount; // money


    @ManyToOne(optional = false)
    private Client client;


    public String toString() {
        return "Account(id=" + this.getId() + ", amount=" + this.getAmount() + ")";
    }
}
