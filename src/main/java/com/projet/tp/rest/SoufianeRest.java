package com.projet.tp.rest;

import com.projet.tp.entity.Categorie;
import com.projet.tp.entity.Client;
import com.projet.tp.entity.Secteur;
import com.projet.tp.entity.Type_produit;
import com.projet.tp.service.SoufianeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user3")
public class SoufianeRest {
    @Autowired
    SoufianeService soufianeService;

    @GetMapping("/tous/categorie/{id}")
    public Categorie findByIdC(@PathVariable("id") Long id){
        Categorie cat = soufianeService.findByIdCat(id);

        return cat;
    }

    @GetMapping("/tous/secteur/{id}")
    public ResponseEntity<Secteur> findByIdS(@PathVariable("id") Long id){
        Secteur sect = soufianeService.findByIdSec(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("token","value1");
        return new ResponseEntity<>(sect, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/tous/typeproduit/{id}")
    public ResponseEntity<Type_produit> findByIdT(@PathVariable("id") Long id){
        Type_produit type = soufianeService.findByIdType(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("token","value1");
        return new ResponseEntity<>(type, responseHeaders, HttpStatus.OK);
    }


    @PutMapping("/booth/client/{id}")
    public Client upClient(@PathVariable("id") Long id, @RequestBody Client client) throws NotFoundException {
        return soufianeService.upClient(id,client);
    }

    @DeleteMapping("/booth/client/{id}")
    public void deleteClient(@PathVariable("id") Long id) throws NotFoundException {
        soufianeService.deleteById(id);
    }

    @PostMapping("/booth/client")
    public Client signClient(@RequestBody Client client) {
       return soufianeService.sign(client);
    }


}

