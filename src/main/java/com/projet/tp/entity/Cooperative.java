package com.projet.tp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cooperative")
public class Cooperative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "secteur")
    private String secteur;
    @Column(name = "region")
    private String region;
    @Column(name = "ville")
    private String ville;
    @Column(name = "date_creation")
    private String dateCreation;
    @Column(name = "n_patente")
    private int N_patente;
    @Column(name = "description")
    private String description;
    @Column(name = "num_tel")
    private String numero_de_tel;
    @Column(name = "email")
    private String email;
    @Column(name = "login")
    private String login;
    @Column(name = "mdp")
    private String mot_de_passe;
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.PERSIST,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="idcoperative")
    private List<Product> produits;

    @ManyToMany(fetch = FetchType.EAGER )
    @JoinTable(name="cooperative_roles",
            joinColumns  =@JoinColumn(name="cooperative_id"),
            inverseJoinColumns = @JoinColumn(name="roles_id")
    )
    private List<Role> roles;


    @Override
    public String toString() {
        return "Cooperative{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", secteur='" + secteur + '\'' +
                ", region='" + region + '\'' +
                ", ville='" + ville + '\'' +
                ", dateCreation='" + dateCreation + '\'' +
                ", N_patente=" + N_patente +
                ", description='" + description + '\'' +
                ", numero_de_tel='" + numero_de_tel + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                '}';
    }

    public Cooperative() {
    }
    public int getN_patente() {
        return N_patente;
    }

    public List<Product> getProduits() {
        return produits;
    }

    public void setProduits(List<Product> produits) {
        this.produits = produits;
    }

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

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getN_patenteente() {
        return N_patente;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setN_patente(int n_patente) {
        N_patente = n_patente;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumero_de_tel() {
        return numero_de_tel;
    }

    public void setNumero_de_tel(String numero_de_tel) {
        this.numero_de_tel = numero_de_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
}
