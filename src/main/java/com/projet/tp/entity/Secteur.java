package com.projet.tp.entity;

import javax.persistence.*;

@Entity
@Table(name = "secteur")

public class Secteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "libelle")
    private String libelle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    public Secteur(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Secteur() {

    }

    public Secteur(String libelle) {
        this.libelle = libelle;
    }
}
