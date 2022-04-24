package com.projet.tp.service;

import com.projet.tp.entity.Cooperative;
import com.projet.tp.entity.Product;

import java.util.List;

public interface HamzaService {
    public List<Product> findAll();
    public Product findone(int id);
    public void deleteById(int id_produit);
    void save(Product produit);

    List<Product> findByIdcoperative(int id_coperative);

    Product findonecop(int id_produit, int idcoperative);

    void deleteByIdCoperative(int id_produit, int idcoperative);

}
