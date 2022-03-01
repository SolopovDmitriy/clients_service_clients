package com.example.clients_service.repositories;

import com.example.clients_service.models.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Long> {

}
