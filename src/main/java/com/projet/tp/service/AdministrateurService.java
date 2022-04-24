package com.projet.tp.service;

import com.projet.tp.entity.Administarteur;
import com.projet.tp.entity.Composant;
import com.projet.tp.entity.Region;
import com.projet.tp.entity.Secteur;

public interface AdministrateurService {

    public Administarteur UpdateAdministrateur(Administarteur administarteur);
    public Composant saveOrUpdateComposant(Composant composant);
    public Region saveOrUpdateRegion(Region region);
    public Secteur saveOrUpdateSecteur(Secteur secteur);
    public void deleteComposant(int id);
    public void deleteRegion(int id);
    public void deleteSecteur(int id);




}
