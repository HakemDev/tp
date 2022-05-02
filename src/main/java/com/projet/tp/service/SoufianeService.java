package com.projet.tp.service;


import com.projet.tp.entity.*;
import javassist.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface SoufianeService {

     Categorie findByIdCat(int id);
     Type_produit findByIdType(int id);
     Secteur findByIdSec(int id);
     
     void deleteById(int id)  throws NotFoundException;
     Client sign(Client clt);
     Client upClient(Client client);
     List<Administarteur> findall();
     Administarteur findByid(int id);
    Client findByEmail(String email);
}
