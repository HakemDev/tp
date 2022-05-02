package com.projet.tp.service;


import com.projet.tp.dao.*;
import com.projet.tp.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class SoufianeServiceImpl implements SoufianeService {
    @Autowired
    AdministrateurRepository repository;
    @Autowired
    CategoryRepo categoryRepository;
    @Autowired
    ClientRepo clientRepository;
    @Autowired
    SecteurRepo secteurRepository;
    @Autowired
    Type_prodRepo typeproduitRepository;

/////////////////Partie categorie
    //chercher une categorie de produits
    public Categorie findByIdCat(int id){
        Optional<Categorie> result=categoryRepository.findById(id);
        Categorie categorie;
        if(result.isPresent())
        {
            categorie=result.get();
        }
        else {
            throw new RuntimeException("la categorie "+id +" n'existe pas");
        }
        return categorie;
    }

/////////////////Partie Type de produit
    //chercher un type de produits
    public Type_produit findByIdType(int id) {
        Optional<Type_produit> result=typeproduitRepository.findById(id);
        Type_produit type_produit;
        if(result.isPresent())
        {
            type_produit=result.get();
        }
        else {
            throw new RuntimeException("la categorie "+id +" n'existe pas");
        }
        return type_produit;
    }

/////////////////Partie secteur
    //chercher un secteur par son id
    public Secteur findByIdSec(int id) {
        Optional<Secteur> result=secteurRepository.findById(id);
        Secteur secteur;
        if(result.isPresent())
        {
            secteur=result.get();
        }
        else {
            throw new RuntimeException("le secteur "+id +" n'existe pas");
        }
        return secteur;
    }

/////////////////Partie Client
    //Supprimer un client
    public void deleteById(int id) {
            Administarteur user=repository.findById(id).get();
            int si=user.getRoles().size();
            for(int j=0;j<(si);j++)
                {
                    System.out.println("b "+j);
                    if(user.getRoles().get(j).getName().equals("ROLE_CLIENT"))
                        {
                           repository.deleteById(id);
                        }
                    else{
                        System.out.println("il n'a pas de client avec id "+id);
                    }
                }
    }

    //client s'enregistre
    public Client sign(Client clt) {
        return clientRepository.save(clt);
    }

    //modifier client
    @Override
    public Client upClient(Client client) {
        return clientRepository.save(client);
    }

    //Extraire tous les clients
    @Override
    public List<Administarteur> findall() {
        List<Administarteur> administrateur=repository.findAll();

        List<Administarteur> adminfinal=new ArrayList<>();
        System.out.println("ccc");
        for(int i=0;i<(administrateur.size());i++)
            {
                System.out.println("a "+i);
                int si=administrateur.get(i).getRoles().size();

                for(int j=0;j<(si);j++)
                    {
                        System.out.println("b "+j);
                        if(administrateur.get(i).getRoles().get(j).getName().equals("ROLE_CLIENT"))
                           {
                               System.out.println("c "+administrateur.get(i));
                              adminfinal.add(administrateur.get(i));
                           }
                    }
            }
        return adminfinal;
    }

    //Extraire un client
    @Override
    public Administarteur findByid(int id) {
        Administarteur user=repository.findById(id).get();
        int si=user.getRoles().size();
        for(int j=0;j<(si);j++)
            {
                if(user.getRoles().get(j).getName().equals("ROLE_CLIENT"))
                    {
                        return user;
                    }
                else
                    {
                        throw new RuntimeException("n'a pas de client");
                    }
            }
        return user;
    }

    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }


}


