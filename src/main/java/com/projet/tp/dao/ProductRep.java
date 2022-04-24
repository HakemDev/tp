package com.projet.tp.dao;

import com.projet.tp.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRep extends JpaRepository<Product, Integer> {
    List<Product> findByIdcoperative(int idcoperative);
    Product findByIdcoperativeAndId(int idcoperative,int id);
    void deleteByIdcoperativeAndId(int idcoperative,int id);
}
