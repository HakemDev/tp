package com.projet.tp.dao;

import com.projet.tp.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
    //public Client findByName(String nomclt);
}





