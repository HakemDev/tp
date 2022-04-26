package com.projet.tp.service;


import com.projet.tp.entity.Categorie;
import com.projet.tp.entity.Client;
import com.projet.tp.entity.Secteur;
import com.projet.tp.entity.Type_produit;
import com.projet.tp.dao.CategoryRepo;
import com.projet.tp.dao.ClientRepo;
import com.projet.tp.dao.SecteurRepo;
import com.projet.tp.dao.Type_prodRepo;
import org.springframework.stereotype.Service;
import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional

public class SoufianeServiceImpl implements SoufianeService {
    @Autowired
    CategoryRepo categoryRepository;

    @Autowired
    ClientRepo clientRepository;

    @Autowired
    SecteurRepo secteurRepository;

    @Autowired
    Type_prodRepo typeproduitRepository;

    public Categorie findByIdCat(Long id){          //chercher une categorie de produits
        return categoryRepository.findById(id).get();
    }



    public Type_produit findByIdType(Long id) {          //chercher un type de produits
        return typeproduitRepository.findById(id).get();
    }

    public Secteur findByIdSec(Long id) {          //chercher un secteur
        return secteurRepository.findById(Math.toIntExact(id)).get();
    }


    public Client upClient(Long id, Client client)  throws NotFoundException {    //client modifie ses infos
        Client clt = clientRepository.findById(id).get();
      /*  if(clt.isEmpty()) {
            throw new IllegalStateException("Client n'existe pas");
        }*/
        clt.setNom(clt.getNom());
        clt.setPrenom(clt.getPrenom());
        clt.setNum_tele(clt.getNum_tele());
        clt.setLogin(clt.getLogin());
        clt.setPass(clt.getPass());
        return clientRepository.save(clt);
    }

    public void deleteById(Long id)  throws NotFoundException{      //Client supprime son compte
        Optional<Client> c = clientRepository.findById(id);
      /*  if(c.isEmpty()) {
            throw new IllegalStateException("Client n'existe pas");
        } */
        clientRepository.deleteById(id);
    }

    public Client sign(Client clt) {        //client s'enregistre
        return clientRepository.save(clt);
    }
    /*
    public List<Product> findAll(){        voir les produits
        return productRepository.findAll();
    }
     */


}


