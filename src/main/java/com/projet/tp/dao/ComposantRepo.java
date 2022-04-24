package com.projet.tp.dao;

import com.projet.tp.entity.Composant;
import com.projet.tp.entity.Cooperative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComposantRepo extends JpaRepository<Composant, Integer> {

}
