package com.example.clients_service;

import com.example.clients_service.models.Account;
import com.example.clients_service.models.Client;
import com.example.clients_service.models.Gender;
import com.example.clients_service.models.Telephone;
import com.example.clients_service.repositories.AccountRepository;
import com.example.clients_service.repositories.ClientRepository;
import com.example.clients_service.repositories.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ClientsServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(ClientsServiceApplication.class, args);
    }

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TelephoneRepository telephoneRepository;

    @Autowired
    private AccountRepository accountRepository;


    @EventListener(ApplicationReadyEvent.class)
    public void applicationReade() {
        System.out.println(clientRepository);

        List<Client> clients = Arrays.asList(
                new Client(0L, "A", "N", "P",
                        LocalDate.of(1999, 12, 12), "email@gmail.com", Gender.MALE, null, null),
                new Client(0L, "A", "N", "P",
                        LocalDate.of(1998, 12, 12), "email@gmail.com", Gender.FEMALE, null, null),
                new Client(0L, "A", "N", "P",
                        LocalDate.of(1997, 12, 12), "email@gmail.com", Gender.MALE, null, null)
                );
        clientRepository.saveAll(clients); //

        Client client1 = clientRepository.getById(1L);
        Client client2 = clientRepository.getById(2L);
        Client client3 = clientRepository.getById(3L);





        List<Telephone> telephones = Arrays.asList(
                new Telephone(0L, 1111, client1),
                new Telephone(0L, 2222, client1),
                new Telephone(0L, 33333, client2),
                new Telephone(0L, 44444, client2),
                new Telephone(0L, 55555, client3)
        );
        telephoneRepository.saveAll(telephones);

        List<Account> accounts = Arrays.asList(
                new Account(0L, 100, client1),
                new Account(0L, 200, client1),
                new Account(0L, 3000, client2),
                new Account(0L, 4000, client2),
                new Account(0L, 5000, client3)
        );
        accountRepository.saveAll(accounts);



        clientRepository.findAll().forEach(System.out::println);
//        System.out.println();
//        //System.out.println(clientRepository.findById(1L));
//        clientRepository.findAllBySurnameAndNameAndPatronymic(
//                "A","N","P"
//        ).forEach(System.err::println);


    }

}
