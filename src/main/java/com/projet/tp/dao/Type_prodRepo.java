package com.projet.tp.dao;



import com.projet.tp.entity.Type_produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Type_prodRepo extends JpaRepository<Type_produit, Long> {
    //public Type_produit findByName(String nomtype);
}
