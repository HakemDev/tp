package com.projet.tp.entity;

import javax.persistence.*;


@Entity
@Table(name ="type_produit")
public class Type_produit {

    public Type_produit() {

    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public Type_produit(int idType ,String libelle) {
        this.idType = idType;
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Type_produit{" +
                "idType=" + idType +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idType;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Column(name="libelle")
    private String libelle;
}
