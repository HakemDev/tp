package com.projet.tp.dao;


import com.projet.tp.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Categorie, Integer>{

}
