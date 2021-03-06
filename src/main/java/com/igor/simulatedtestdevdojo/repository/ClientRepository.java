package com.igor.simulatedtestdevdojo.repository;

import com.igor.simulatedtestdevdojo.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByUsername(String username);
}
