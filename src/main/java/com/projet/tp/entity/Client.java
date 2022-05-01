package com.projet.tp.entity;


import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    public Client() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", num_tele='" + num_tele + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    // id int nom string prenom num de tel string login pass
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private int id;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    private String nom;
    private String prenom;

    public String getNum_tele() {
        return num_tele;
    }

    public void setNum_tele(String num_tele) {
        this.num_tele = num_tele;
    }

    private String num_tele;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private String login;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    private String pass;

    public Client(int id, String nom, String prenom, String num_tele, String login, String pass) {
        this.id = id;
        this.nom= nom;
        this.prenom=prenom;
        this.num_tele=num_tele;
        this.login=login;
        this.pass=pass;
    }
}
