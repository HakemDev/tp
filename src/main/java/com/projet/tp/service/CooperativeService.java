package com.projet.tp.service;

import com.projet.tp.entity.Cooperative;

import java.util.List;

public interface CooperativeService {

    public List<Cooperative> getAllCooperatives();
    public Cooperative getCooperativeById(int id);
    public Cooperative saveOrUpdateCooperative(Cooperative cooperative);
    public void deleteCooperative(int id);
    public List<Cooperative> getCooperativeByNom(String nom);
    public List<Cooperative> getCooperativeByRegion(String region);
    public List<Cooperative> getCooperativeBysecteur(String secteur);

    Cooperative getAllCooperativesBymail(String email);
}
