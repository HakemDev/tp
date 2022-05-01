package com.projet.tp.service;

import com.projet.tp.dao.AdministrateurRepository;
import com.projet.tp.dao.ComposantRepo;
import com.projet.tp.dao.RegionRepo;
import com.projet.tp.dao.SecteurRepo;
import com.projet.tp.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdministrateurServiceImpl implements AdministrateurService
{

    @Autowired
    AdministrateurRepository repository;
    @Autowired
    ComposantRepo composantRepo;
    @Autowired
    RegionRepo regionRepo;
    @Autowired
    SecteurRepo secteurRepo;


    @Override
    public Administarteur UpdateAdministrateur(Administarteur administarteur) {
        repository.save(administarteur);
        return administarteur;
    }

    @Override
    public Composant saveOrUpdateComposant(Composant composant) {
        return composantRepo.save(composant);
    }

    @Override
    public Region saveOrUpdateRegion(Region region) {
        return regionRepo.save(region);
    }

    @Override
    public Secteur saveOrUpdateSecteur(Secteur secteur) {
        return secteurRepo.save(secteur);
    }

    @Override
    public void deleteComposant(int id) {
        composantRepo.deleteById(id);

    }

    @Override
    public void deleteRegion(int id) {
        regionRepo.deleteById(id);

    }

    @Override
    public void deleteSecteur(int id) {
        secteurRepo.deleteById((id));

    }

    @Override
    public Administarteur getadminBYemail(String email) {
        return repository.findByEmail(email);
    }
}
