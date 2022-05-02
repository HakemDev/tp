package com.projet.tp.service;


import com.projet.tp.dao.*;
import com.projet.tp.entity.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class HamzaServiceImpl implements HamzaService {

    private final ProductRep productRep;

////////////////Partie produits

    //afficher tpus les produits
    @Override
    public List<Product> findAll() {
        return productRep.findAll();
    }

    //chercher un seule produit
    @Override
    public Product findone(int id) {
        Optional<Product> result=productRep.findById(id);
        Product produit;
        if(result.isPresent())
        {
            produit=result.get();
        }
        else {
            throw new RuntimeException("le produit "+id +" n'existe pas");
        }
        return produit;
    }

    //Supprimer un produit
    @Override
    public void deleteById(int id_produit) {
        productRep.deleteById(id_produit);
    }

    //ajouter ou modifier un produit
    @Override
    public void save(Product produit) {
        productRep.save(produit);
    }

    //afficher les produits d'un coperative
    @Override
    public List<Product> findByIdcoperative(int id_coperative) {
        List<Product> produits=productRep.findByIdcoperative(id_coperative);
        return productRep.findByIdcoperative(id_coperative);
    }

    //afficher un seule produit d'un seule coperative
    @Override
    public Product findonecop(int id_produit, int idcoperative) {
        return productRep.findByIdcoperativeAndId(idcoperative,id_produit);
    }

    //Supprimer un produit precis d'une coperative precise
    @Override
    public void deleteByIdCoperative(int id_produit, int idcoperative) {
        productRep.deleteByIdcoperativeAndId(idcoperative,id_produit);
        log.info("produit deleted");
    }


}
