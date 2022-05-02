package com.projet.tp.rest;

import com.projet.tp.entity.*;
import com.projet.tp.service.AdministrateurService;
import com.projet.tp.service.CooperativeService;
import com.projet.tp.service.SoufianeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user3")
public class SoufianeRest {
    @Autowired
    SoufianeService soufianeService;
    @Autowired
    CooperativeService service;
////////////////Partie categorie
    @GetMapping("/tous/categorie/{id}")
    public Categorie findByIdC(@PathVariable("id") int id){
        Categorie cat = soufianeService.findByIdCat(id);

        return cat;
    }

////////////////Partie Secteur
    @GetMapping("/tous/secteur/{id}")
    public ResponseEntity<Secteur> findByIdS(@PathVariable("id") int id){
        Secteur sect = soufianeService.findByIdSec(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("token","value1");
        return new ResponseEntity<>(sect, responseHeaders, HttpStatus.OK);
    }

////////////////Partie type du produit
    @GetMapping("/tous/typeproduit/{id}")
    public ResponseEntity<Type_produit> findByIdT(@PathVariable("id") int id){
        Type_produit type = soufianeService.findByIdType(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("token","value1");
        return new ResponseEntity<>(type, responseHeaders, HttpStatus.OK);
    }

////////////////Partie Client
    //*supprimer un client
    @DeleteMapping("/booth/client/{id}")
    public void deleteClient(@PathVariable("id") int id) throws NotFoundException {
        soufianeService.deleteById(id);
    }

    //modifier un client
    @PutMapping("/booth/client")
    public Client upClient(@RequestBody Client client) throws NotFoundException {
        return soufianeService.upClient(client);
    }

    //Ajouter un client ou modifier
    @PostMapping("/administrateur/addclient")
    public Administarteur saveCooperative(@RequestBody Administarteur administarteur)
        {
            service.sign(administarteur);
            return administarteur;
        }
    //*Extraire tous les clients
    @GetMapping("/administrateur/clients")
    public List<Administarteur> clients()
    {
        return soufianeService.findall();
    }

    //*Extraire client a partir de son ID
    @GetMapping("/booth/cl/{id]")
    public Administarteur client(@PathVariable int id)
    {
        return soufianeService.findByid(id);
    }


}

