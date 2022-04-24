package com.projet.tp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.projet.tp.entity.Composant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="produit")
@JsonIgnoreType
@JsonIgnoreProperties
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_produit")
    private int id;

    @Column(name="nom")
    private String nom;

    @Column(name ="description")
    private String description;

    @Column(name ="prix")
    private double prix;

    @Column(name ="quantite")
    private int quantite;

    @Column(name ="type")
    private String type;

    @Column(name ="genre")
    private String genre;

    @Column(name ="unite")
    private String unite;

    @Column(name="idcoperative")
    private int idcoperative;


    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL})

    @JoinTable(name="intermediaire",
            joinColumns  =@JoinColumn(name="id_produit"),
            inverseJoinColumns = @JoinColumn(name="id_composant")
    )

    private List<Composant> composants;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public int getIdcoperative() {
        return idcoperative;
    }

    public void setIdcoperative(int idcoperative) {
        this.idcoperative = idcoperative;
    }

    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List<Composant> composants) {
        this.composants = composants;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                ", type='" + type + '\'' +
                ", genre='" + genre + '\'' +
                ", unite='" + unite + '\'' +
                ", idcoperative=" + idcoperative +
                ", composants=" + composants +
                '}';
    }

    public Product() {
    }

    public Product(String nom, String description, double prix, int quantite, String type, String genre, String unite, int idcoperative, List<Composant> composants)
    {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.type = type;
        this.genre = genre;
        this.unite = unite;
        this.idcoperative = idcoperative;
        this.composants = composants;
    }
}
