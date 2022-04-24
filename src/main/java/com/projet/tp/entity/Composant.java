package com.projet.tp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="composant")
@JsonIgnoreProperties
@JsonIgnoreType
public class Composant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compsant")
    private int id_compsant;

    @Column(name = "nom")
    private String nom;

    @Column(name = "region")
    private String region;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade ={CascadeType.ALL})

    @JoinTable(name="intermediaire",
            joinColumns = @JoinColumn(name = "id_composant"),
            inverseJoinColumns = @JoinColumn(name = "id_produit"))

    private List<Product> produits;



    public int getId_compsant() {
        return id_compsant;
    }

    public void setId_compsant(int id_compsant) {
        this.id_compsant = id_compsant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Composant{" +
                "id_compsant=" + id_compsant +
                ", nom='" + nom + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    public Composant(String nom, String region) {
        this.nom = nom;
        this.region = region;
    }

    public Composant() {
    }

}
