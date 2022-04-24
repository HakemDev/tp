package com.projet.tp.dao;

import com.projet.tp.entity.Cooperative;
import com.projet.tp.entity.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecteurRepo extends JpaRepository<Secteur, Integer> {
}
