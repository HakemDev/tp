package com.projet.tp.rest;

import com.projet.tp.entity.Cooperative;
import com.projet.tp.service.CooperativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cooperative")
@EnableAutoConfiguration
public class CooperativeRest {
    @Autowired
    CooperativeService service;

    @PostMapping("/save")
    public Cooperative saveCooperative(@RequestBody Cooperative cooperative)
    {
        service.saveOrUpdateCooperative(cooperative);
        return cooperative;

    }
    @GetMapping("/list")
    public List<Cooperative> listCooperative()
    {
        return service.getAllCooperatives();

    }
    @GetMapping("/list/email/{email}")
    public Cooperative listCooperativeBymail(@PathVariable String email)
    {
        return service.getAllCooperativesBymail(email);

    }
    @GetMapping("/list/{id}")
    public Cooperative getCooperativeById(@PathVariable int id)
    {
        return service.getCooperativeById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteCooperative(@PathVariable(value = "id") int id )
    {
        service.deleteCooperative(id);
        return "cooperative with id="+id+" deleted successfuly";
    }
    @GetMapping("/list/nom/{nom}")
    public List<Cooperative> getCooperativeByNom(@PathVariable String nom)
    {
        return service.getCooperativeByNom(nom);
    }

    @GetMapping("/list/region/{region}")
    public List<Cooperative> getCooperativeByRegion(@PathVariable String region)
    {
        return service.getCooperativeByRegion(region);
    }


    @GetMapping("/list/secteur/{secteur}")
    public List<Cooperative> getCooperativeBySecteur(@PathVariable String secteur)
    {
        return service.getCooperativeBysecteur(secteur);
    }



}
