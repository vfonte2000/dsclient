package com.client.client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.client.client.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
