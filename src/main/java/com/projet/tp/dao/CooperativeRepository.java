package com.projet.tp.dao;

import com.projet.tp.entity.Cooperative;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CooperativeRepository extends JpaRepository<Cooperative, Integer> {


    List<Cooperative> findByNom(String nom);

    List<Cooperative> findByRegion(String region);

    List<Cooperative> findBySecteur(String secteur);

    Cooperative findByEmail(String email);

}
