package com.projet.tp.service;


import com.projet.tp.entity.Categorie;
import com.projet.tp.entity.Client;
import com.projet.tp.entity.Secteur;
import com.projet.tp.entity.Type_produit;
import javassist.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface SoufianeService {

     Categorie findByIdCat(Long id);
     Type_produit findByIdType(Long id);
     Secteur findByIdSec(Long id);
     Client upClient(Long id, Client client) throws NotFoundException;
     void deleteById(Long id)  throws NotFoundException;
     Client sign(Client clt);

}
