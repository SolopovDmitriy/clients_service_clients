package com.example.clients_service.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "telephones")
public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int number;

//    @ManyToOne
//    @JoinColumn(name = "ClientId", referencedColumnName = "Id", nullable = false)

    @ManyToOne(optional = false)
    private Client client;


    public String toString() {
        return "Telephone number=" + this.getNumber();
    }
}

