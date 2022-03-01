package com.example.clients_service.models;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
//
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String surname;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String patronymic;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = true, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private Gender gender;

//    @Enumerated(EnumType.ORDINAL)
//    private Gender gender;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Telephone> telephones;

    @OneToMany(mappedBy = "client",  cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Account> accounts;


    public String toString() {
        return "Client(id=" + this.getId() + ", surname=" + this.getSurname() + ", name=" + this.getName() +
                ", patronymic=" + this.getPatronymic() + ", birthDate=" + this.getBirthDate() +
                ", email=" + this.getEmail() + ", gender=" + getGender() +  ", telephones=" + this.getTelephones() + ", accounts=" + this.getAccounts() + ")";
    }
}
