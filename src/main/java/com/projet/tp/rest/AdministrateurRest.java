package com.projet.tp.rest;

import com.projet.tp.entity.Administarteur;
import com.projet.tp.entity.Composant;
import com.projet.tp.entity.Region;
import com.projet.tp.entity.Secteur;
import com.projet.tp.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrateur")
@EnableAutoConfiguration

public class AdministrateurRest {

    @Autowired
    AdministrateurService service;

    @PostMapping("/save")
    public Administarteur saveAdministrateur(@RequestBody Administarteur administarteur)
    {
        service.UpdateAdministrateur(administarteur);
        return administarteur;

    }
    @PostMapping("/composant/save")
    public Composant ajouteroumodifierC(@RequestBody Composant composant){
        return service.saveOrUpdateComposant(composant);
    }

    @PostMapping("/region/save")
    public Region ajouteroumodifierR(@RequestBody Region region){
        return service.saveOrUpdateRegion(region);
    }
    @PostMapping("/secteur/save")
    public Secteur ajouteroumodifierS(@RequestBody Secteur secteur){
        return service.saveOrUpdateSecteur(secteur);
    }


    @DeleteMapping("/composant/delete/{id}")
    public void suppC(@PathVariable int id){
        service.deleteComposant(id);
    }

    @DeleteMapping("/region/delete/{id}")
    public void suppR(@PathVariable int id){
        service.deleteRegion(id);
    }


    @DeleteMapping("/secteur/delete/{id}")
    public void suppS(@PathVariable int id){
        service.deleteSecteur(id);
    }

}
