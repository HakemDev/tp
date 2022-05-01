package com.projet.tp.service;

import com.projet.tp.dao.AdministrateurRepository;
import com.projet.tp.dao.ComposantRepo;
import com.projet.tp.dao.RegionRepo;
import com.projet.tp.dao.SecteurRepo;
import com.projet.tp.entity.Administarteur;
import com.projet.tp.entity.Composant;
import com.projet.tp.entity.Region;
import com.projet.tp.entity.Secteur;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor

public class AdministrateurServiceImpl implements AdministrateurService
{
    private final PasswordEncoder passwordEncoder;

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
        administarteur.setPassword(passwordEncoder.encode(administarteur.getPassword()));
        System.out.println("ddddddddddd");
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
        return null;
    }
}
