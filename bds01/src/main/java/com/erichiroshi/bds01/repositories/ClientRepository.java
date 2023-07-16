package com.erichiroshi.bds01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erichiroshi.bds01.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}