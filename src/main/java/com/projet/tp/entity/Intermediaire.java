/*package com.projet.tp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import javax.persistence.*;

@Entity
@Table(name="intermediaire")
@JsonIgnoreProperties
@JsonIgnoreType
public class Intermediaire {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_produit")
    private int id_produit;
    @Id
    @Column(name="id_composant")
    private int id_composant;

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_composant() {
        return id_composant;
    }

    public void setId_composant(int id_composant) {
        this.id_composant = id_composant;
    }

    public Intermediaire() {
    }

    @Override
    public String toString() {
        return "Intermediaire{" +
                "id_produit=" + id_produit +
                ", id_composant=" + id_composant +
                '}';
    }

    public Intermediaire(int id_composant) {
        this.id_composant = id_composant;
    }

    public Intermediaire(int id_produit, int id_composant) {
        this.id_produit = id_produit;
        this.id_composant = id_composant;
    }
}
*/
