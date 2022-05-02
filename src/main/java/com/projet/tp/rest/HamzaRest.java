package com.projet.tp.rest;


import com.projet.tp.entity.Cooperative;
import com.projet.tp.entity.Product;
import com.projet.tp.service.CooperativeService;
import com.projet.tp.service.HamzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user2")
@RequiredArgsConstructor
public class HamzaRest {

    private final HamzaService hamzaService;

////////////////Partie produits
    //afficher tpus les produits
    @GetMapping("/tous/products")
    public List<Product> affichage(){
        System.out.println("Test reussi");
        return hamzaService.findAll();
    }
    //Supprimer un produit
    @DeleteMapping("/cop/produit/delete/{id_produit}")
    public String deleteByid(@PathVariable int id_produit)
        {
            Product produit=hamzaService.findone(id_produit);
            if(produit == null )
            {
                throw new RuntimeException("produit not found");
            }
            hamzaService.deleteById(id_produit);
            return "produit deleted";
        }

    //ajouter un produits
    @PostMapping("/cop/add/product")
        public String add(@RequestBody Product produit)
        {
            hamzaService.save(produit);
            return "produit est bien ajouté";
        }

    //Modifier un produit
    @PutMapping("/cop/update/product")
    public String update(@RequestBody Product produit)
    {
        hamzaService.save(produit);
        return "produit est bien modifiée";
    }

    //afficher un produit
    @GetMapping("/tous/produi/{id_produit}")
    public Product produit(@PathVariable int id_produit)
        {
            return hamzaService.findone(id_produit);
        }

    //afficher les produits d'un coperative
    @GetMapping("/cop/products/{id_coperative}")
    public List<Product> ProductCoperative(@PathVariable int id_coperative )
        {
            return hamzaService.findByIdcoperative(id_coperative);
        }

    //afficher un seule produit d'un seule coperative
    @GetMapping("/cop/produi/{idcoperative}/{id_produit}")
    public Product produit(@PathVariable int id_produit,@PathVariable int idcoperative)
        {
            return hamzaService.findonecop(id_produit,idcoperative);
        }

    //Supprimer un produit precis d'une coperative precise
    @DeleteMapping("/cop/cooperative/produit/delete/{idcoperative}/{id_produit}")
    public String deleteByidProduitandidCoperative(@PathVariable int id_produit,@PathVariable int idcoperative)
    {
        Product produit=hamzaService.findonecop(id_produit,idcoperative);
        if(produit == null )
        {
            throw new RuntimeException("produit not found");
        }
        hamzaService.deleteByIdCoperative(id_produit,idcoperative);
        return "produit deleted";
    }
}
