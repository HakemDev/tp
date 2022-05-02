package com.projet.tp.rest;

import com.projet.tp.dao.AdministrateurRepository;
import com.projet.tp.entity.*;
import com.projet.tp.service.AdministrateurService;
import com.projet.tp.service.CooperativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrateur")
@EnableAutoConfiguration
@RequiredArgsConstructor
public class AdministrateurRest {

    @Autowired
    AdministrateurService service;
    @Autowired
    CooperativeService service2;

    @Autowired
    AdministrateurRepository aa;
    //Afficher  copeartives
    @GetMapping("/{email}")
    public Administarteur listCooperative(@PathVariable String email)
    {
        return aa.findByEmail(email);

    }

    //Ajouter ou modifier une une coperative
    @PostMapping("/save")
    public Administarteur saveAdministrateur(@RequestBody Administarteur administarteur)
    {
        service2.saveorUpdateAdmini(administarteur);
        return administarteur;

    }

    //ajouter ou modifier ou modifier une region
    @PostMapping("/region/save")
    public Region ajouteroumodifierR(@RequestBody Region region){
        return service.saveOrUpdateRegion(region);
    }


    //supprimer une region
    @DeleteMapping("/region/delete/{id}")
    public void suppR(@PathVariable int id){
        service.deleteRegion(id);
    }

    //ajouter ou modifier une secteur
    @PostMapping("/secteur/save")
    public Secteur ajouteroumodifierS(@RequestBody Secteur secteur){
        return service.saveOrUpdateSecteur(secteur);
    }


    //supprimer un secteur a partir de son id
    @DeleteMapping("/secteur/delete/{id}")
    public void suppS(@PathVariable int id){
        service.deleteSecteur(id);
    }

    //Supprimer une composant
    @DeleteMapping("/composant/delete/{id}")
    public void suppC(@PathVariable int id){
        service.deleteComposant(id);
    }



}
