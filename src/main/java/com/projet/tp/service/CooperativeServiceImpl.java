package com.projet.tp.service;

import com.projet.tp.dao.CooperativeRepository;
import com.projet.tp.entity.Cooperative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CooperativeServiceImpl implements CooperativeService {
    @Autowired
    CooperativeRepository repository;


    @Override
    public List<Cooperative> getAllCooperatives() {
        System.out.println("aaa");
        return (List<Cooperative>) repository.findAll() ;
    }

    @Override
    public Cooperative getCooperativeById(int id) {
        return repository.findById(id).get() ;
    }

    @Override
    public Cooperative saveOrUpdateCooperative(Cooperative cooperative) {
        repository.save(cooperative);
        return cooperative;

    }

    @Override
    public void deleteCooperative(int id) {
        repository.deleteById(id);

    }

    @Override
    public List<Cooperative> getCooperativeByNom(String nom) {
        return repository.findByNom(nom) ;
    }

    @Override
    public List<Cooperative> getCooperativeByRegion(String region) {
        return repository.findByRegion(region);
    }

    @Override
    public List<Cooperative> getCooperativeBysecteur(String secteur) {
        return repository.findBySecteur(secteur);
    }

    @Override
    public Cooperative getAllCooperativesBymail(String email) {
        return repository.findByEmail(email);
    }
}
