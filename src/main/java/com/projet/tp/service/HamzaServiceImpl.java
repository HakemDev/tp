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


    @Override
    public List<Product> findAll() {
        return productRep.findAll();
    }

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

    @Override
    public void deleteById(int id_produit) {
        productRep.deleteById(id_produit);
    }

    @Override
    public void save(Product produit) {
        System.out.println("haha");
        productRep.save(produit);
    }

    @Override
    public List<Product> findByIdcoperative(int id_coperative) {
        List<Product> produits=productRep.findByIdcoperative(id_coperative);
        return productRep.findByIdcoperative(id_coperative);
    }

    @Override
    public Product findonecop(int id_produit, int idcoperative) {
        return productRep.findByIdcoperativeAndId(idcoperative,id_produit);
    }

    @Override
    public void deleteByIdCoperative(int id_produit, int idcoperative) {
        productRep.deleteByIdcoperativeAndId(idcoperative,id_produit);
        log.info("produit deleted");
    }


}
