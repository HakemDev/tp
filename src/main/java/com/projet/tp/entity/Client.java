package com.projet.tp.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String password;


}
