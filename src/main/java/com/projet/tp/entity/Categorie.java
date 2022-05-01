package com.projet.tp.entity;

import javax.persistence.*;

@Entity
@Table(name = "categorie")

public class Categorie {


    public Categorie(Long idCategorie,String libelle) {
        this.idCategorie = idCategorie;
        this.libelle = libelle;
    }

    public Categorie() {

    }

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idCategorie;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "idCategorie=" + idCategorie +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    @Column(name="libelle")
    private String libelle;
}
