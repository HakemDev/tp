package com.projet.tp.entity;

import javax.persistence.*;

@Entity
@Table(name ="secteur")
public class Secteur {
    public Secteur() {

    }

    public int getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(int idSecteur) {
        this.idSecteur = idSecteur;
    }

    public String getLibelle() {
        return libelle;
    }
    @Override
    public String toString() {
        return "Secteur{" +
                "idSecteur=" + idSecteur +
                ", libelle='" + libelle + '\'' +
                '}';
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public Secteur(int idSecteur, String libelle) {
        this.idSecteur = idSecteur;
        this.libelle = libelle;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idSecteur;
    @Column(name="libelle")
    private String libelle;




}
