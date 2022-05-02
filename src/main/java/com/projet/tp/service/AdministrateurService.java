package com.projet.tp.service;

import com.projet.tp.entity.*;

public interface AdministrateurService {

    public Administarteur UpdateAdministrateur(Administarteur administarteur);
    public Composant saveOrUpdateComposant(Composant composant);
    public Region saveOrUpdateRegion(Region region);
    public Secteur saveOrUpdateSecteur(Secteur secteur);
    public void deleteComposant(int id);
    public void deleteRegion(int id);
    public void deleteSecteur(int id);
    public Administarteur getadminBYemail(String email);

}
